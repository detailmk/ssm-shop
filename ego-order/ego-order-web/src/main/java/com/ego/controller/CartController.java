package com.ego.controller;

import com.ego.pojo.Admin;
import com.ego.service.CartServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 购物车Controller
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceI cartService;

    /**
     * 获取购物车数量
     *
     * @param request
     * @return
     */
    @RequestMapping("/getCartNum")
    @ResponseBody
    public Integer getCartNum(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        return cartService.getCartNum(admin);
    }

}
