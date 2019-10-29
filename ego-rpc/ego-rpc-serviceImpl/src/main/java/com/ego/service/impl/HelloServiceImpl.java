package com.ego.service.impl;

import com.ego.service.HelloServiceI;

/**
 * @see( 功能介绍 ) : 测试服务
 * @version( 版本号 ) : 1.0  *
 * @author( 创建人 ) : Dylan  *
 * @since : JDK 1.8
 */
public class HelloServiceImpl implements HelloServiceI {

    @Override
    public String sayHello() {
        System.out.println("HelloServiceImpl");
        return "success";
    }

}