package com.ego.service;


import com.ego.util.JsonUtil;
import com.ego.vo.GoodsCategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class GoodsCategoryListServiceTest {
    @Autowired
    private GoodsCategoryListServiceI goodsCategoryListService;

    @Test
    public void testSayHello() {
        List<GoodsCategoryVo> goodsCategoryVos = goodsCategoryListService.selectAllCategoryList();
        System.out.println(JsonUtil.object2JsonStr(goodsCategoryVos));
    }
}
