package com.ego.controller;


import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.service.CartServiceI;
import com.ego.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceI cartService;

    /**
     * 添加至购物车
     *
     * @param cartVo
     * @param request
     * @return
     */
    @RequestMapping("/addToCart")
    @ResponseBody
    public BaseResult addToCart(CartVo cartVo, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        return cartService.addToCart(cartVo, admin);
    }

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

    /**
     * 获取购物车列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getCartList")
    public String getCartList(HttpServletRequest request, Model model) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        model.addAttribute("cartResult", cartService.getCartList(admin));
        return "cart/cart-index";
    }

  /*  @Autowired
    private CartServiceI cartService;

    *//**
     * 添加购物车
     * @param cart
     * @param request
     * @return
     *//*
    @RequestMapping("/addToCart")
    @ResponseBody
    public BaseResult addCart(CartVo cart, HttpServletRequest request){
        //设置添加购物车时间
        cart.setAddTime(new Date());
        //从session中获取登录用户信息
        Admin admin= (Admin) request.getSession().getAttribute("userTicket");
        //添加购物车
        return cartService.addToCart(cart,admin);
    }

    @RequestMapping("/getCartNum")
    @ResponseBody
    public Integer getCartNum(HttpServletRequest request){
        //从session中获取登录用户信息
        Admin admin= (Admin) request.getSession().getAttribute("userTicket");
        //查询购物车数量
        return cartService.getCartNum(admin);
    }*/
}
