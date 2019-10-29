package com.ego.service.impl;

import com.ego.service.CookieServiceI;
import com.ego.util.CookieUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see(功能介绍) : CookieService
 * @version(版本号) : 1.0
 * @author(创建人) : Dylan
 * @since : JDK 1.8
 */
@Service
public class CookieServiceImpl implements CookieServiceI {

    /**
     * 获取Cookie
     *
     * @param request
     * @param cookieName
     * @return
     */
    @Override
    public String getCookie(HttpServletRequest request, String cookieName) {
        return CookieUtil.getCookieValue(request, cookieName);
    }

    /**
     * 设置Cookie
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     */
    @Override
    public void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue) {
        CookieUtil.setCookie(request, response, cookieName, cookieValue);
    }

    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     * @param cookieName
     */
    @Override
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        CookieUtil.deleteCookie(request, response, cookieName);
    }

}
