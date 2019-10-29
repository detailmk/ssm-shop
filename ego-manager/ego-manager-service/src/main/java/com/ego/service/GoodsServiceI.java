package com.ego.service;

import com.ego.pojo.Goods;
import com.ego.result.BaseResult;

public interface GoodsServiceI {
    //添加商品
    public BaseResult saveGoods(Goods goods);
    /**
     * 商品列表 根据分页查询

     *
     * @param goods
     * @param pageNum
     * @param pageSize
     * @return
     */
    BaseResult selectGoodsListByPage(Goods goods, Integer pageNum, Integer pageSize);
}
