package com.ego.service;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.vo.CartVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消费购物车服务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class CartServiceITest {
    @Autowired
    private CartServiceI cartService;

    /**
     * 添加购物车
     */
    @Test
    public void teatAddCart() {
        Admin admin = new Admin();
        admin.setAdminId((short) 1);
        CartVo cartVo = new CartVo();
        cartVo.setAddTime(new Date());
        cartVo.setGoodsName("Apple iPhone 6s Plus 16G 玫瑰金 移动联通电信4G手机");
        cartVo.setGoodsNum(2);
        cartVo.setMarketPrice(new BigDecimal(6100));
        BaseResult result = cartService.addToCart(cartVo, admin);
        System.out.println(result.getCode());
    }

    /**
     * 测试查询购物车数量
     */
    @Test
    public void testGetCartNum() {
        Admin admin = new Admin();
        admin.setAdminId((short) 1);

        Integer cartNum = cartService.getCartNum(admin);
        System.out.println("cartNum:" + cartNum);
    }

}

