package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/toPreOrder")
    public String toPreOrder(HttpServletRequest request){
        //跳转订单页面
        return "redirect:"+request.getSession().getServletContext().getAttribute("orderUrl")
                +"order/preOrder";
    }
}
