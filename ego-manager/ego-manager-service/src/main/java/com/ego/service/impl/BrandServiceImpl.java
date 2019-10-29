package com.ego.service.impl;

import com.ego.mapper.BrandMapper;
import com.ego.pojo.Brand;
import com.ego.pojo.BrandExample;
import com.ego.service.BrandListServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandListServiceI {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询品牌列表
     *
     * @return
     */
    @Override
    public List<Brand> selectBrandList() {
        return brandMapper.selectByExample(new BrandExample());
    }
}
