package com.ego.service.impl;

import com.ego.mapper.GoodsMapper;
import com.ego.pojo.Goods;
import com.ego.pojo.GoodsExample;
import com.ego.result.BaseResult;
import com.ego.service.GoodsServiceI;
import com.ego.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GoodServiceImpl implements GoodsServiceI {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    @Override
    public BaseResult saveGoods(Goods goods) {
        //添加商品分类之前删除缓存
        redisTemplate.delete(redisTemplate.keys("goods*"));
        String htmlEsp = HtmlUtils.htmlEscape(goods.getGoodsContent(), "UTF-8");
        goods.setGoodsContent(htmlEsp);
        int result = goodsMapper.insertSelective(goods);
        //考虑保存后继续添加信息返回主键
        BaseResult baseResult = BaseResult.error();
        if (result > 0) {
            baseResult = BaseResult.success();
            baseResult.setMessage(String.valueOf(goods.getGoodsId()));
        }
        return baseResult;
    }

    /**
     * 查询商品列表
     * @param goods
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public BaseResult selectGoodsListByPage(Goods goods, Integer pageNum, Integer pageSize) {
       //构建分页对象
        PageHelper.startPage(pageNum,pageSize);
        //创建查询对象
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        // 初始化 redis的 key
    /*
        分析：
        此功能查询分为七种 ( 所有条件都包含分页参数 ) ：

            a. 无条件查询

            b. 根据分类查询

            c. 根据品牌查询

            d. 根据关键词查询

            e. 根据分类 _ 品牌查询

            f. 根据分类 _ 关键词查询

            g. 根据品牌 _ 关键词查询

        无条件查询 key
            goods:list:currentPage_:pageSize_:catId_:brandId_:goodsName_
        条件查询 key
            goods:currentPage_:pageSize_:catId_123:brandId_:goodsName_( 根据分类查询 )
            goods:currentPage_:pageSize_:catId_:brandId_123:goodsName_( 根据品牌查询 )
            goods:currentPage_:pageSize_:catId_:brandId_:goodsName_ 华为 ( 根据关键词查询 )
            cgoods:currentPage_:pageSize_:catId_123:brandId_123:goodsName_( 根据分类 _ 品牌查询 )
            goods:currentPage_:pageSize_:catId_123:brandId_:goodsName_ 华为 ( 根据分 类 _ 关键词查询 )
            goods:currentPage_:pageSize_:catId_:brandId_123:goodsName_ 华为 ( 根据品牌 _ 关键词查询 )
     */

    String goodsListKeyStrArr[]= new String[]{"goods:pageNum_"+pageNum+":pageSize_"+pageSize+":",
                                                "catId_:","brandId_:","goodsName_:"};


        //设置查询参数
        //商品分类参数
        if(null!=goods.getCatId()&&0!=goods.getCatId()){
            criteria.andCatIdEqualTo(goods.getCatId());
            goodsListKeyStrArr[1]="catId_"+goods.getCatId()+":";
        }
        //商品品牌参数
        if(null!=goods.getBrandId()&&0!=goods.getBrandId()){
            criteria.andBrandIdEqualTo(goods.getBrandId());
            goodsListKeyStrArr[2]="brandId_"+goods.getBrandId()+":";
        }
        //模糊查询商品名称
        if(null!=goods.getGoodsName()&&goods.getGoodsName().trim().length()>0){
            criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
            goodsListKeyStrArr[3]="goodsName_"+goods.getGoodsName()+":";
        }
        //拼接存储redis库中的key
        String goodsListstr="";
        for(String key:goodsListKeyStrArr){
            goodsListstr +=key;
        }
        //查询redis里是否有缓存数据
        String goodsListJson= redisTemplate.opsForValue().get(goodsListstr);
        if(null!=goodsListJson&&goodsListJson.length()>0){
            PageInfo<Goods> pageInfo= JsonUtil.jsonStr2Object(goodsListJson,PageInfo.class);
            return BaseResult.success(pageInfo);
        }
        //查询商品设置到分页对象中
        List<Goods> goodsList=goodsMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(goodsList)&&goodsList.size()>0){
            PageInfo<Goods> goodsPageInfo=new PageInfo<>(goodsList);
            //将查询数据存在redis中
            redisTemplate.opsForValue().set(goodsListstr,JsonUtil.object2JsonStr(goodsPageInfo));
            return BaseResult.success(goodsPageInfo);
        }else{
            //设置查不到数据的缓存为空字符串失效时间60s
            redisTemplate.opsForValue().set(goodsListstr,JsonUtil.object2JsonStr(new PageInfo<>(new ArrayList<Goods>())),60, TimeUnit.SECONDS);

        }

        return BaseResult.error();
    }


    public static void main(String[] args) {
        /**
         * 测试 html
         文本转义与反转义

         */
        String htmlEscape = HtmlUtils.htmlEscape("<p><span>测试 html 文本转义与反转义！</span></p>",
                "UTF-8");
        System.out.println(htmlEscape);
        htmlEscape="en; cursor: pointer;&quot;&gt;&lt;/span&gt;&lt;/p&gt;&lt;p&gt;&lt;span class=&quot;c-icons-outer&quot; style=&quot;overflow: hidden; display: inline-block; vertical-align: bottom;&quot;&gt;&lt;span class=&quot;c-icons-inner&quot; style=&quot;margin-left: -4px; display: inline-block;&quot;&gt;&lt;/span&gt;&lt;/span&gt;&amp;nbsp;-&amp;nbsp;&lt;a href=&quot;http://cache.baiducontent.com/c?m=9d78d513d9d431df4f9e94697c12c0176940c72362d88a5339968449e079461e506694e17a7f5255899e203416af3e0db7af2b&amp;p=8c36c64ad4df11a05bed9e665c5486&amp;newp=9c759a46d6c95db701f1df2d021490231610db2151d7d0166b82c825d7331b001c3bbfb423271600d5c1796301aa4b59e1f73275370923a3dda5c91d9fb4c57479943f6d6c57&amp;user=baidu&amp;fm=sc&amp;query=%BB%A2%C6%CB&amp;qid=f7dbbc750036094d&amp;p1=6&quot; target=&quot;_blank&quot; class=&quot;m&quot; style=&quot;color: rgb(102, 0, 102);&quot;&gt;百度快照&lt;/a&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;";
        String htmlUnescape = HtmlUtils.htmlUnescape(htmlEscape);
        System.out.println(htmlUnescape);
    }
}

