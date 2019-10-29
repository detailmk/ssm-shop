package com.ego.service;

import com.ego.result.EgoPageInfo;
import com.ego.util.JsonUtil;
import com.ego.vo.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class SearchServiceTest {
    @Autowired
    private SearchServiceI searchService;

    @Test
    public void testDoSearch() {
        EgoPageInfo<GoodsVo> pageInfo = searchService.doSearch("手机", 1, 10);
        System.out.println("总条数：" + pageInfo.getCount());
        System.out.println("pageInfo：" + JsonUtil.object2JsonStr(pageInfo));
    }

}