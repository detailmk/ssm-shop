package com.ego.interceptor;

import com.ego.pojo.Admin;
import com.ego.service.SSOServiceI;
import com.ego.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component("orderLoginInterceptor")
public class OrderLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private SSOServiceI ssoService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${user.ticket}")
    private String userTicket;

    @Value("${ego.portal.url}")
    private String portalUrl;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {


        //获取用户票据
        String cookieValue = CookieUtil.getCookieValue(request, "userTicket");

        //收据不存在重定向到登录页面
        if (null == cookieValue || cookieValue.length() <= 0) {
            response.sendRedirect(portalUrl+"login?redirectUrl="
                    +request.getRequestURL());
            return false;
        }
        //收据存在进行校验
        Admin admin = ssoService.validate(cookieValue);
        //如果用户不存在重定向到登录
        if (null == admin) {
            response.sendRedirect(portalUrl+"login?redirectUrl="
                    +request.getRequestURL());
            return false;
        }
        //用户校验成功,将用户信息存进session
        request.getSession().setAttribute("user", admin);
        //重新设置收据失效时间
        redisTemplate.expire(userTicket + cookieValue, 30, TimeUnit.MINUTES);
        return true;

       /* //获取用户票据
        String cookieValue = CookieUtil.getCookieValue(request, "userTicket");
        //校验收据和用户
        if(null!=cookieValue&&cookieValue.length()>0){
            Admin admin=ssoService.validate(cookieValue);
            if(null!=admin){
                //用户校验成功,将用户信息存进session
                request.getSession().setAttribute("user", admin);
                //重新设置收据失效时间
                redisTemplate.expire(userTicket + cookieValue, 30, TimeUnit.MINUTES);
                return true;
            }
        }
        //收据不存在时重定向到门户系统登录页
        response.sendRedirect(portalUrl+"login?redirectUrl="
                +request.getRequestURL());
        return false;*/
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
