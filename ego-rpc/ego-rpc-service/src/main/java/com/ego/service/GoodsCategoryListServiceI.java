package com.ego.service;

import com.ego.vo.GoodsCategoryVo;

import java.util.List;

public interface GoodsCategoryListServiceI {
    //查询所有商品分类(带层级关系)
    List<GoodsCategoryVo> selectAllCategoryList();
}
