package com.ego.service;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.result.CartResult;
import com.ego.vo.CartVo;

/**
 * 购物车服务
 */
public interface CartServiceI {

    /**
     * 添加至购物车
     *
     * @param cartVo
     * @param admin
     * @return
     */
    BaseResult addToCart(CartVo cartVo, Admin admin);

    /**
     * 获取购物车数量
     *
     * @param admin
     * @return
     */
    Integer getCartNum(Admin admin);

    /**
     * 获取购物车列表及总金额
     *
     * @param admin
     * @return
     */
    CartResult getCartList(Admin admin);

    /**
     * 清空购物车
     *
     * @param admin
     * @return
     */
    BaseResult clearCart(Admin admin);

}
