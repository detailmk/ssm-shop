package com.ego.service.impl;

import com.ego.mapper.GoodsCategoryMapper;
import com.ego.pojo.GoodsCategory;
import com.ego.pojo.GoodsCategoryExample;
import com.ego.service.GoodsCategoryListServiceI;
import com.ego.util.JsonUtil;
import com.ego.vo.GoodsCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryListServiceI {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    //商品分类列表redis key
    @Value("${goods.category.list.key}")
    private String goodsCategoryListKey;



    /**
     * 查询所有商品分类
     *用集合存储,体现父子类关系
     * @return
     */
    @Override
    public List<GoodsCategoryVo> selectAllCategoryList() {
        //查询redis是否有缓存数据
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String goodsCategorystr = valueOperations.get(goodsCategoryListKey);
        if(null!=goodsCategorystr&&goodsCategorystr.length()>0){
            return JsonUtil.jsonToList(goodsCategorystr,GoodsCategoryVo.class);
        }
        //创建查询对象
        GoodsCategoryExample example=new GoodsCategoryExample();
        //设置所有一级分类(parentId=0;level=1)
        example.createCriteria().andParentIdEqualTo((short) 0).andLevelEqualTo((byte) 1);
       //查询一级分类
        List<GoodsCategory> gcList1=goodsCategoryMapper.selectByExample(example);
        //创建返回结果集合存储一级分类
        List<GoodsCategoryVo> gcvList1=new ArrayList<>();
        for (GoodsCategory gc1:gcList1){
            //创建vo对象
            GoodsCategoryVo gcv1=new GoodsCategoryVo();
            //复制属性
            BeanUtils.copyProperties(gc1,gcv1);
            //查询二级分类
            //清空查询条件
            example.clear();
            //重新设置查询条件(二级分类)
            example.createCriteria().andParentIdEqualTo(gc1.getId()).andLevelEqualTo((byte) 2);
            //查询二级分类
            List<GoodsCategory> gcList2=goodsCategoryMapper.selectByExample(example);
            //创建返回结果集合存储二级分类
            List<GoodsCategoryVo> gcvList2=new ArrayList<>();
            for (GoodsCategory gc2:gcList2) {
                //创建vo对象
                GoodsCategoryVo gcv2 = new GoodsCategoryVo();
                //复制属性
                BeanUtils.copyProperties(gc2, gcv2);
                //查询三级分类
                //清空查询条件
                example.clear();
                //重新设置查询条件(三级分类)
                example.createCriteria().andParentIdEqualTo(gc2.getId()).andLevelEqualTo((byte) 3);
                //查询三级分类
                List<GoodsCategory> gcList3 = goodsCategoryMapper.selectByExample(example);
                //创建返回结果集合存储三级分类
                List<GoodsCategoryVo> gcvList3 = new ArrayList<>();
                for (GoodsCategory gc3 : gcList3) {
                    //创建vo对象
                    GoodsCategoryVo gcv3 = new GoodsCategoryVo();
                    //复制属性
                    BeanUtils.copyProperties(gc3, gcv3);
                    gcvList3.add(gcv3);
                }
                gcv2.setChildren(gcvList3);
                gcvList2.add(gcv2);
            }
            gcv1.setChildren(gcvList2);
            gcvList1.add(gcv1);
        }
        //将查询数据添加到缓存
        valueOperations.set(goodsCategoryListKey,JsonUtil.object2JsonStr(gcvList1));
        return gcvList1;
    }

}
