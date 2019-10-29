package com.ego.controller;

import com.ego.pojo.Admin;
import com.ego.pojo.AdminWithBLOBs;
import com.ego.result.BaseResult;
import com.ego.service.CookieServiceI;
import com.ego.service.SSOServiceI;
import com.ego.service.SendMailServiceI;
import com.ego.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SSOServiceI ssoService;
    @Autowired
    private CookieServiceI cookieService;
    @Autowired
    private UserServiceI userService;

  /*  @Autowired
    private SendMailServiceI sendMailService;*/

    @RequestMapping("/login")
    @ResponseBody
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response){
        //登录生成收据
        String ticket = ssoService.login(admin);
        if(null==ticket){
            return BaseResult.error();
        }
        //收据校验成功,存进cookie
        cookieService.setCookie(request,response,"userTicket",ticket);
        //再将用户信息存到session,来页面显示
        return BaseResult.success();
    }
    /**
     * 安全退出
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 获取ticket
        String ticket = cookieService.getCookie(request, "userTicket");
        // 清除redis
        ssoService.logout(ticket);
        // 清除session
        request.getSession().removeAttribute("user");
        // 清除cookie
        cookieService.deleteCookie(request, response, "userTicket");
        return "index";
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseResult register(AdminWithBLOBs admin) {
        //用户注册
        BaseResult result = userService.logon(admin);
       /* //注册成功发送邮件
        if (200 == result.getCode())
            sendMailService.sendMail(admin.getEmail(), admin.getUserName(), "EGO商城帐号注册成功邮件", "registerEmail");*/
        return result;
    }

}
