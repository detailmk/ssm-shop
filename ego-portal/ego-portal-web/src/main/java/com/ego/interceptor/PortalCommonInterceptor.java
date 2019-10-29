package com.ego.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("portalCommonInterceptor")
public class PortalCommonInterceptor implements HandlerInterceptor {
    @Value("${ego.order.url}")
    private String orderurl;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取Application对象中到的url地址
        ServletContext context=httpServletRequest.getSession().getServletContext();
        String orderURL= (String) context.getAttribute("orderUrl");
        //url地址为空添加到Application对象中
        if(null==orderURL||orderURL.length()<=0) {
            context.setAttribute("orderUrl", orderurl);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
