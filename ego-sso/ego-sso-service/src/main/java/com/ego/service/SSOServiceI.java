package com.ego.service;

import com.ego.pojo.Admin;

public interface SSOServiceI {
 
    /**
     *登录认证方法返回票据 ticket
     * @param admin
     * @return
     */
    String login(Admin admin);
 
    /**
     * 验证票据 ticket返回用户信息
     *
     * @param ticket
     * @return
     */
    Admin validate(String ticket);



    /**
     * 安全退出
     *
     * @param ticket
     */
    void logout(String ticket);
} 