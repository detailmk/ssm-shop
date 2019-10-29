package com.ego.service.impl;

import com.ego.mapper.AdminMapper;
import com.ego.pojo.AdminWithBLOBs;
import com.ego.result.BaseResult;
import com.ego.service.UserServiceI;
import com.ego.util.Md5Util;
import com.ego.util.RandomUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 用户注册
     * @param admin
     * @return
     */
    @Override
    public BaseResult logon(AdminWithBLOBs admin) {
        String salt = RandomUtil.getRandom2(4);
        admin.setEcSalt(salt);// 盐
        admin.setPassword(Md5Util.getMd5WithSalt(admin.getPassword(), salt));
        int result = adminMapper.insertSelective(admin);
        // 用户注册成功，发送邮件
        if (result > 0) {
            Map<String, String> sendMap = new HashMap<>();
            /*
             * receiveMail 收件人邮箱
             * receiveName 收件人名称
             * subject     邮件主题(EGO商城帐号注册成功邮件)
             * html        邮件模板
             */
            sendMap.put("receiveMail", admin.getEmail());
            sendMap.put("receiveName", admin.getUserName());
            sendMap.put("subject", "EGO商城帐号注册成功邮件");
            sendMap.put("html", "registerEmail");
            amqpTemplate.convertAndSend(sendMap);
            return BaseResult.success();
        }
        return BaseResult.error();
    }
}
