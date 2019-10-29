package com.ego.service.impl;

import com.ego.result.BaseResult;
import com.ego.service.SendMailServiceI;
import com.ego.util.ReadHtmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件发送服务实现
 */
public class SendMailServiceImpl implements SendMailServiceI {

    private static Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);

    @Value("${email.account}")
    private String emailAccount;
    @Value("${email.password}")
    private String emailPassword;
    @Value("${email.host}")
    private String emailHost;
    @Value("${email.sendName}")
    private String emailSendName;


    /**
     * 邮件发送
     *
     * @param receiveMail 收件人邮箱
     * @param receiveName 收件人名称
     * @param subject     邮件主题(EGO商城帐号注册成功邮件)
     * @param html        邮件模板
     * @return
     */
    @Override
    public BaseResult sendMail(String receiveMail, String receiveName, String subject, String html) {
        try {
            // 1. 创建参数配置对象, 用于连接邮件服务器的参数配置
            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", emailHost);
            // 发送邮件协议名称（JavaMail规范要求）
            props.setProperty("mail.transport.protocol", "smtp");

            // 2. 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getInstance(props);
            session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

            // 3. 创建一封邮件
            MimeMessage message = new MimeMessage(session);

            // 4. From: 发件人
            message.setFrom(new InternetAddress(emailAccount, emailSendName, "UTF-8"));

            // 5. To: 收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveName, "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject(subject, "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            // 读取html文件内容
            String info = ReadHtmlUtil.getMailString(html);
            // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart body = new MimeBodyPart();
            // 设置html内容
            body.setContent(info, "text/html;charset=utf-8");
            // 将MimeMultipart设置为邮件内容
            mainPart.addBodyPart(body);
            message.setContent(mainPart);

            // 6. 设置发件时间
            message.setSentDate(new Date());

            // 7. 保存设置
            message.saveChanges();

            // 8. 根据 Session获取邮件传输对象
            Transport transport = session.getTransport();
            transport.connect(emailAccount, emailPassword);

            // 9. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());

            // 12. 关闭连接
            transport.close();
        } catch (MessagingException | UnsupportedEncodingException e) {
            logger.error("邮件发送失败，收件人邮箱为：" + receiveMail + "，失败原因：" + e.getMessage());
            return BaseResult.error();
        }
        return BaseResult.success();
    }

}
