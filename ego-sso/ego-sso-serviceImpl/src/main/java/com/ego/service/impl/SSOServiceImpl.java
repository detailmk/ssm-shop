package com.ego.service.impl;


import com.ego.mapper.AdminMapper;
import com.ego.pojo.Admin;
import com.ego.pojo.AdminExample;
import com.ego.service.SSOServiceI;
import com.ego.util.JsonUtil;
import com.ego.util.Md5Util;
import com.ego.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SSOServiceImpl implements SSOServiceI {

    private static Logger logger = LoggerFactory.getLogger(SSOServiceImpl.class);
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${user.ticket}")
    private String userTicket;
    /**
     * 登录认证方法返回票据 ticket
     * @param admin
     * @return
     */
    @Override
    public String login(Admin admin) {
        //参数非空校验
        String username=admin.getUserName().trim();
        String passward=admin.getPassword().trim();

        if(null==username||"".equals(username)){
            logger.error("用户名为空");
            return null;
        }
        if(null==passward||"".equals(passward)){
            logger.error("passward为空");
            return null;
        }

        //通过用户名密码校验登录信息,用户信息唯一返回收据
        AdminExample example=new AdminExample();
        example.createCriteria().andUserNameEqualTo(username);
        //根据用户名查询用户信息
        List<Admin> admins = adminMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(admins)){
            logger.error("该用户不存在 用户名:"+username);
            return null;
        }

        //如果容器出现多个用户
        if(admins.size()>1){
            logger.error("system error more users"+username);
            return null;
        }

        //查询密码是否正确
        Admin admin1 = admins.get(0);
        if(!admin1.getPassword().equals(Md5Util.getMd5WithSalt(passward,admin1.getEcSalt()))){
            logger.error("password error mk");
            return  null;
        }
        // 用户名和密码一致，登录成功返回票据信息         //
        // 生成票据信息存入 redis ，页面借助 cookie 存储票据的 key
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        String ticket = UUIDUtil.getUUID();
        valueOperations.set(userTicket+ticket, JsonUtil.object2JsonStr(admin1),30, TimeUnit.MINUTES);
        return ticket;

    }

    /**
     * 验证票据 ticket
     * 返回用户信息
     * @param ticket
     * @return
     */
    @Override
    public Admin validate(String ticket) {
         if(null==ticket||ticket.length()<=0){
             logger.error("ticket is null mk");
             return null;
         }
         ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        String adminjson = valueOperations.get(userTicket + ticket);
        if(null==adminjson||adminjson.length()<=0){
            logger.error("ticket dont have admin info mk");
            return null;
        }
        return JsonUtil.jsonStr2Object(adminjson,Admin.class);
    }

    @Override
    public void logout(String ticket) {
        if(null==ticket||ticket.length()<=0){
            return;
        }
        //根据收据信息查询用户信息
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        String adminjson = valueOperations.get(ticket);
        if(null==adminjson||adminjson.length()<=0){
            return;
        }
        //用户信息存在,删除
        redisTemplate.delete(userTicket+ticket);
    }

} 