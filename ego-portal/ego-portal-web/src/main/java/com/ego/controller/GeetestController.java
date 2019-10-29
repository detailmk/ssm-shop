package com.ego.controller;

import com.ego.config.GeetestConfig;
import com.ego.pojo.AdminWithBLOBs;
import com.ego.result.BaseResult;
import com.ego.sdk.GeetestLib;
import com.ego.service.SendMailServiceI;
import com.ego.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 极验验证Controller
 */
@Controller
@RequestMapping("/gt")
public class GeetestController {

    @Autowired
    private UserServiceI userService;

  /*  @Autowired
    private SendMailServiceI sendMailService;*/

    /**
     * 初始化（API1），获取流水标识并设置状态码
     *
     * @param request
     */
    @RequestMapping(value = "/register1", method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request) {

        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());

        String resStr = "{}";

        String userid = "test";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", userid); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);

        return gtSdk.getResponseStr();
    }

    /**
     * 二次验证（API2），包括正常流程和宕机情况
     *
     * @param request
     */
    @RequestMapping(value = "/ajax-validate1", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult doPost(AdminWithBLOBs admin, HttpServletRequest request) {

        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());

        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //从session中获取userid
        String userid = (String) request.getSession().getAttribute("userid");

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", userid); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证

            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
            System.out.println(gtResult);
        } else {
            // gt-server非正常情况下，进行failback模式验证

            System.out.println("failback:use your own server captcha validate");
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
            System.out.println(gtResult);
        }

        BaseResult result = null;
        if (gtResult == 1) {
            // 验证成功 以下就是项目核心代码
            // 用户注册
            result = userService.logon(admin);
            // 注册成功发送邮件
            if (200 == result.getCode())
              /*  sendMailService.sendMail(admin.getEmail(), admin.getUserName(),
                        "EGO商城帐号注册成功邮件", "registerEmail");*/
            return result;
        } else {
            // 验证失败
            result = BaseResult.error();
        }
        return result;
    }

}
