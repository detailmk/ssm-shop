package com.ego.controller;

import com.ego.service.GoodsCategoryListServiceI;
import com.ego.vo.GoodsCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goodsCategory")
public class GoodCategoryController {
    @Autowired
    private GoodsCategoryListServiceI goodsCategoryListService;

    @RequestMapping("/list")
    @ResponseBody
    public List<GoodsCategoryVo> list(){
        return goodsCategoryListService.selectAllCategoryList();
    }
}
