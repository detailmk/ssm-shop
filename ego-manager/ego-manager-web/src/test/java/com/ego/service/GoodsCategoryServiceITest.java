package com.ego.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ego.util.JsonUtil;
import com.ego.vo.GoodsCategoryVo;

/**
 * @see( 功能介绍 ) : 商品分类 Service
测试类

 * @version( 版本号 ) : 1.0
 * @author( 创建人 ) : Dylan
 * @since : JDK 1.8
 */
/*
 * @RunWith
就是一个运行器

 * @RunWith(JUnit4.class) 就是指用 JUnit4
来运行

 * @RunWith(SpringJUnit4ClassRunner.class) ，让测试运行于 Spring
测试环境

 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @ContextConfiguration Spring
整合 JUnit4
测试时，使用注解引入多个配置文件

 * 单个文件 @ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
 * 多个文件 @ContextConfiguration(locations = {"classpath:spring/spring1.xml",
"classpath:mybatis/config.xml"})
 */
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class GoodsCategoryServiceITest {

    @Autowired
    private GoodsCategoryListServiceI goodsCategoryService;

    /**
     * 测试查询所有商品分类      */
    @Test
    public void testSelectCategoryListFroView() {
        List<GoodsCategoryVo> gcvList = goodsCategoryService.selectAllCategoryList();
        System.out.println(JsonUtil.object2JsonStr(gcvList));
    }
}