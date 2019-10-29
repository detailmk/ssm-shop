package com.ego.service;

import com.ego.pojo.GoodsCategory;
import com.ego.vo.GoodsCategoryVo;

import java.util.List;

public interface GoodsCategoryListServiceI {
    //查询商品分类父列表
    List<GoodsCategory> selectCategoryList(Short parantId);
    //添加商品分类
    int savegoodsCategory(GoodsCategory goodsCategory);
    //查询所有商品分类(带层级关系)
    List<GoodsCategoryVo> selectAllCategoryList();
    //查询所有商品分类
    List<GoodsCategory> selectAllCategory();
}
