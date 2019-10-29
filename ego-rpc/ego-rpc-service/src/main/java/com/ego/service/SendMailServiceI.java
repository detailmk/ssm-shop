package com.ego.service;

import com.ego.result.BaseResult;

/**
 * 邮件发送服务
 */
public interface SendMailServiceI {

    /**
     * 发送邮件
     *
     * @param receiveMail   收件人邮箱
     * @param receiveName   收件人名称
     * @param subject       邮件主题
     * @param html          邮件模板
     * @return
     */
    BaseResult sendMail(String receiveMail, String receiveName, String subject, String html);

}
