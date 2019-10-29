package com.ego.controller;

import com.ego.pojo.Goods;
import com.ego.pojo.GoodsCategory;
import com.ego.pojo.GoodsImages;
import com.ego.result.BaseResult;
import com.ego.result.FileResult;
import com.ego.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private GoodsCategoryListServiceI goodsCategoryListService;
    @Autowired
    private BrandListServiceI brandListService;
    @Autowired
    private GoodsServiceI goodsService;
    @Autowired
    private FileUploadServiceI fileUploads;
    @Autowired
    private GoodsImagesServiceI goodsImagesService;

    //********************************商品分类begin************************************
    @RequestMapping("/category/list")
    public String categorylist(Model model) {
        model.addAttribute("gclist", goodsCategoryListService.selectAllCategoryList());
        return "product/category/category-list";
    }

    @RequestMapping("/category/add")
    public String categoryadd(Model model) {
        //查询商品分类父列表
        model.addAttribute("gcList", goodsCategoryListService.selectCategoryList((short) 0));
        return "product/category/category-add";
    }

    @RequestMapping(value = "/category/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsCategory> categoryListByParentId(@PathVariable Short parentId) {
        //查询商品分类
        return goodsCategoryListService.selectCategoryList(parentId);
    }

    /**
     * 添加商品分类
     *
     * @param goodsCategory
     * @return
     */
    @RequestMapping("/category/save")
    @ResponseBody
    public BaseResult saveGoodsCategory(GoodsCategory goodsCategory) {
        int result = goodsCategoryListService.savegoodsCategory(goodsCategory);
        return result > 0 ? BaseResult.success() : BaseResult.error();
    }
    //********************************商品分类end************************************
    //********************************商品begin************************************

    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/list")
    public String productList(Model model) {
        //查询商品分类
        model.addAttribute("gcList", goodsCategoryListService.selectAllCategory());
        //查询品牌
        model.addAttribute("brandList",brandListService.selectBrandList());
        return "product/product-list";
    }

    /**
     * 商品列表分页查询
     *
     * @param goods
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listForPage")
    @ResponseBody
    public BaseResult productListForPage(Goods goods, Integer pageNum, Integer pageSize) {
        return goodsService.selectGoodsListByPage(goods,pageNum,pageSize);
    }
    /**
     * 商品添加
     *
     * @return
     */
    @RequestMapping("/add")
    public String productAdd(Model model) {
        //查询商品分类
        model.addAttribute("gcList", goodsCategoryListService.selectCategoryList((short) 0));
        //查询品牌
        model.addAttribute("brandList",brandListService.selectBrandList());
        return "product/product-add";
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public BaseResult saveGoods(Goods goods){
        return goodsService.saveGoods(goods);
    }
    /**
     * 商品相册保存
     *
     * @param file
     * @param goodsId
     * @return
     */
    @RequestMapping("/goodsImages/save")
    @ResponseBody
    public BaseResult goodsImagesSave(MultipartFile file, Integer goodsId) {
        try {
            FileResult fileResult = fileUploads.fileUpload(file.getOriginalFilename(), file.getInputStream());
            // 判断图片是否上传成功
            if (null != fileResult.getFileUrl() && fileResult.getFileUrl().length() > 0) {
                GoodsImages goodsImages = new GoodsImages();
                goodsImages.setImageUrl(fileResult.getFileUrl());
                goodsImages.setGoodsId(goodsId);
                return goodsImagesService.saveGoodsImages(goodsImages);
            }
        } catch (IOException e) {
            logger.error("文件上传失败，失败原因：" + e.getMessage());
        }
        return BaseResult.error();
    }
    //********************************商品end************************************
}
