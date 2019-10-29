package com.ego.controller;

import com.ego.enums.BaseResultEnum;
import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.service.CookieServiceI;
import com.ego.service.SSOServiceI;
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

    @RequestMapping("/login")
    @ResponseBody
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response,String vertify){
        BaseResult result = new BaseResult();
        //校验用户名密码
        if(null==admin.getUserName()||"".equals(admin.getUserName())
                ||null==admin.getPassword()||"".equals(admin.getPassword())){
            result.setCode(BaseResultEnum.PASS_ERROR_03.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_03.getMessage());
            return result;
        }
        //校验验证码
        if(null==vertify||"".equals(vertify)){
            result.setCode(BaseResultEnum.PASS_ERROR_04.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_04.getMessage());
            return result;
        }
        //校验验证码是否正确
        String pictureVerifyKey = (String) request.getSession().getAttribute("pictureVerifyKey");
        if(!pictureVerifyKey.equals(vertify)){
            result.setCode(BaseResultEnum.PASS_ERROR_05.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_05.getMessage());
            return result;
        }
        //登录生成收据
        String ticket = ssoService.login(admin);
        if(null==ticket){
            result.setCode(BaseResultEnum.PASS_ERROR_02.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_02.getMessage());
            return result;
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
        return "login";
    }
}
