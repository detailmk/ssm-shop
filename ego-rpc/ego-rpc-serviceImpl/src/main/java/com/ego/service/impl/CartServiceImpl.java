package com.ego.service.impl;


import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.result.CartResult;
import com.ego.service.CartServiceI;
import com.ego.util.JsonUtil;
import com.ego.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 购物车服务
 */
public class CartServiceImpl implements CartServiceI {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${user.cart}")
    private String userCart;

    /**
     * 添加至购物车
     *
     * @param cartVo
     * @param admin
     * @return
     */
    @Override
    public BaseResult addToCart(CartVo cartVo, Admin admin) {
        if (null == admin || null == admin.getAdminId())
            return BaseResult.error();

        cartVo.setAddTime(new Date());
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        // 根据用户获取购物车信息
        Map<String, String> cartVoMap = hashOperations.entries(userCart + admin.getAdminId());
        // 判断购物车是否为空
        if (CollectionUtils.isEmpty(cartVoMap) || cartVoMap.size() <= 0) {
            // 购物车为空，添加
            putCartVo(hashOperations, admin, cartVo);
        } else {
            // 购物车不为空，判断购物车中是否存在添加的商品
            String cartVoJson = cartVoMap.get(String.valueOf(cartVo.getGoodsId()));
            if (null == cartVoJson || cartVoJson.length() <= 0) {
                // 不存在要添加的商品
                putCartVo(hashOperations, admin, cartVo);
            } else {
                // 添加的商品已存在，修改数量(累加)和价格(重新覆盖)
                CartVo cv = JsonUtil.jsonStr2Object(cartVoJson, CartVo.class);
                cv.setGoodsNum(cv.getGoodsNum() + cartVo.getGoodsNum());
                cv.setMarketPrice(cartVo.getMarketPrice());
                // 重新添加至redis
                putCartVo(hashOperations, admin, cv);
            }
        }
        return BaseResult.success();
    }

    // 添加商品至购物车
    private void putCartVo(HashOperations<String, String, String> hashOperations,
                           Admin admin, CartVo cartVo) {
        hashOperations.put(userCart + admin.getAdminId(),
                String.valueOf(cartVo.getGoodsId()), JsonUtil.object2JsonStr(cartVo));
    }

    /**
     * 获取购物车数量
     *
     * @param admin
     * @return
     */
    @Override
    public Integer getCartNum(Admin admin) {
        if (null == admin || null == admin.getAdminId())
            return 0;

        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        // 根据用户获取购物车信息
        Map<String, String> cartVoMap = hashOperations.entries(userCart + admin.getAdminId());
        // 判断购物车是否为空
        if (CollectionUtils.isEmpty(cartVoMap) || cartVoMap.size() <= 0)
            return 0;
        // 购物车不为空，循环处理返回数量
        Integer total = 0;
        for (Map.Entry<String, String> cartVoM : cartVoMap.entrySet()) {
            CartVo cv = JsonUtil.jsonStr2Object(cartVoM.getValue(), CartVo.class);
            total += cv.getGoodsNum();
        }
        return total;
    }

    /**
     * 获取购物车列表
     *
     * @param admin
     * @return
     */
    @Override
    public CartResult getCartList(Admin admin) {
        if (null == admin || null == admin.getAdminId())
            return null;

        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        // 根据用户获取购物车信息
        Map<String, String> cartVoMap = hashOperations.entries(userCart + admin.getAdminId());
        // 判断购物车是否为空
        if (CollectionUtils.isEmpty(cartVoMap) || cartVoMap.size() <= 0)
            return null;
        // 购物车不为空，循环处理返回集合和总金额
        CartResult result = new CartResult();
        BigDecimal totalPrice = new BigDecimal("0");
        List<CartVo> cartVoList = new ArrayList<>();
        for (Map.Entry<String, String> cartVoM : cartVoMap.entrySet()) {
            CartVo cv = JsonUtil.jsonStr2Object(cartVoM.getValue(), CartVo.class);
            // 四舍五入保留两位小数，不足0补齐
            String marketPriceFormat = new DecimalFormat("0.00").format(cv.getMarketPrice());
            cv.setMarketPrice(new BigDecimal(marketPriceFormat));
            // 计算单个商品的总价
            BigDecimal singlePrice = new BigDecimal(marketPriceFormat).multiply(new BigDecimal(cv.getGoodsNum()));
            // 总金额累加单个商品总价
            totalPrice = totalPrice.add(singlePrice);
            cartVoList.add(cv);
        }
        result.setCartVoList(cartVoList);
        result.setTotalPrice(totalPrice);
        return result;
    }

    /**
     * 清空购物车
     *
     * @param admin
     * @return
     */
    @Override
    public BaseResult clearCart(Admin admin) {
        if (null == admin || null == admin.getAdminId())
            return BaseResult.error();
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        // 根据用户获取购物车信息
        Map<String, String> cartVoMap = hashOperations.entries(userCart + admin.getAdminId());
        // 判断购物车是否为空
        if (CollectionUtils.isEmpty(cartVoMap) || cartVoMap.size() <= 0)
            return BaseResult.error();
        redisTemplate.delete(userCart + admin.getAdminId());
        return BaseResult.success();
    }



   /* @Autowired
    private RedisTemplate<String,Object> redisTemplate;
       *//*      * 初始化 redis      *
      参数一： redis的 key
     *
     参数二： hash的 key
     *
     参数三： hash的 value
     *//*
       private HashOperations<String,String,String> hashOperations=null;

       @Value("${user.cart}")
       private String userCart;

    *//**
     * 添加购物车
      * @param cartVo
     * @param admin
     * @return
     *//*
    @Override
    public BaseResult addToCart(CartVo cartVo, Admin admin) {
        //如果用户不存在直接返回
        if(null==admin||null==admin.getAdminId()){
            return  BaseResult.error();
        }
        //用户存在获取用户id
        Short adminId = admin.getAdminId();
        //查询当前用户购物车信息
        hashOperations=redisTemplate.opsForHash();
        Map<String,String> cartMap=hashOperations.entries(userCart+adminId);

        //如果购物车信息非空,修改购物车信息
        if(null!=cartMap||!cartMap.isEmpty()){
            //根据商品id查询商品信息
            String cartStr = cartMap.get(String.valueOf(cartVo.getGoodsId()));
            //如果商品存在修改商品价格和数量
            if(null!=cartStr&&!"".equals(cartStr)){
                CartVo cart = JsonUtil.jsonStr2Object(cartStr, CartVo.class);
                //修改商品数量
                cart.setGoodsNum(cartVo.getGoodsNum()+cart.getGoodsNum());
                //修改商品价格
                cart.setMarketPrice(cartVo.getMarketPrice());
                //添加到map,覆盖之前的商品信息
                cartMap.put(String.valueOf(cartVo.getGoodsId()),JsonUtil.object2JsonStr(cart));
            }else {
                //商品不存在,新增购物车
                cartMap.put(String.valueOf(cartVo.getGoodsId()),JsonUtil.object2JsonStr(cartVo));
            }
        }else{
            //购物车为空,新增购物车信息
            cartMap=new HashMap<>();
            cartMap.put(String.valueOf(cartVo.getGoodsId()),JsonUtil.object2JsonStr(cartVo));
        }
        //添加redis
        hashOperations.putAll(userCart+adminId,cartMap);
        return BaseResult.success();
    }

    *//**
     * 查询购物车数量
     * @param admin
     * @return
     *//*
    @Override
    public Integer getCartNum(Admin admin) {
        //如果用户不存在直接返回
        if(null==admin||null==admin.getAdminId()){
            return  0;
        }
        //初始化返回数量
        Integer result=0;
        //查询用户购物车信息
        hashOperations=redisTemplate.opsForHash();
        Map<String,String> cartMap=hashOperations.entries(userCart+admin.getAdminId());
        //如果购物车信息不为空,累加
        if(null!=cartMap&&!cartMap.isEmpty()){
            for(Map.Entry<String,String> entry:cartMap.entrySet()){
                //获取cart对象
                CartVo cart=JsonUtil.jsonStr2Object(entry.getValue(),CartVo.class);
                //累加数量
                result+=cart.getGoodsNum();
            }
        }
        return result;
    }

    @Override
    public CartResult getCartList(Admin admin) {
        return null;
    }

    @Override
    public BaseResult clearCart(Admin admin) {
        return null;
    }*/



}
