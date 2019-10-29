package com.ego.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @see( 功能介绍 ) : 测试服务启动类
 * @version( 版本号 ) : 1.0  * @author( 创建人 ) : Dylan  * @since : JDK 1.8
 */
public class RpcRun {

    private final static Logger logger = LoggerFactory.getLogger(RpcRun.class);

    public static void main(String[] args) {
        // 1. 加载 spring 配置文件
        String config = "classpath:spring/applicationContext-*.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 2. 启动
        context.start();
        // 3.while 循环防止自动关闭
        while (true) {
            try {
                Thread.sleep(10000);
                logger.info("Dubbo 服务主进程正在服务！");
            } catch (Exception e) {
                logger.error("Dubbo 服务主进程异常：" + e.getMessage());
            }
        }
    }
}