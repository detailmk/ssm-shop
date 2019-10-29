package com.ego.service.impl;

import com.ego.mapper.GoodsImagesMapper;
import com.ego.pojo.GoodsImages;
import com.ego.result.BaseResult;
import com.ego.service.GoodsImagesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsImagesImpl implements GoodsImagesServiceI {
    @Autowired
    private GoodsImagesMapper goodsImagesMapper;

    @Override
    public BaseResult saveGoodsImages(GoodsImages goodsImages) {
        int result = goodsImagesMapper.insertSelective(goodsImages);
        return result > 0 ? BaseResult.success() : BaseResult.error();
    }
}
