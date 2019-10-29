package com.ego.service;

import com.ego.result.EgoPageInfo;
import com.ego.vo.GoodsVo;

import java.util.List;

/**
 * 搜索商品服务
 */
public interface SearchServiceI {

    //根据参数查询商品
    EgoPageInfo<GoodsVo> doSearch(String searchStr, Integer currentPage, Integer pageSize);
}
