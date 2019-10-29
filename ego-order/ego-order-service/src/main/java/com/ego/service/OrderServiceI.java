package com.ego.service;


import com.ego.pojo.Order;
import com.ego.result.BaseResult;
import com.ego.result.CartResult;

public interface OrderServiceI {
    /**
     * 生成订单
     * @param userId
     * @param cartResult
     * @return
     */
    BaseResult orderSave(CartResult cartResult,Integer userId);


    /**
     * 根据订单编号查询订单信息
     *
     * @param orderSn
     * @return
     */
    Order selectOrderByOrderSn(String orderSn);
}
