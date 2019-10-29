package com.ego.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer catId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.extend_cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer extendCatId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_sn
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String goodsSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_name
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.click_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer clickCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.brand_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.store_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short storeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.comment_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.weight
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.market_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private BigDecimal marketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.shop_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private BigDecimal shopPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.cost_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private BigDecimal costPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.keywords
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String keywords;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_remark
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String goodsRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.original_img
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String originalImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_real
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isReal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_on_sale
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isOnSale;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_free_shipping
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isFreeShipping;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.on_time
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer onTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.sort
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_recommend
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isRecommend;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_new
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isNew;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.is_hot
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte isHot;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.last_update
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer lastUpdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short goodsType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.spec_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short specType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.give_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer giveIntegral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.exchange_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer exchangeIntegral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.suppliers_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Short suppliersId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.sales_sum
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer salesSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.prom_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Byte promType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.prom_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private Integer promId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.commission
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private BigDecimal commission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.spu
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String spu;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.sku
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String sku;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods.goods_content
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private String goodsContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_id
     *
     * @return the value of t_goods.goods_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_id
     *
     * @param goodsId the value for t_goods.goods_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.cat_id
     *
     * @return the value of t_goods.cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.cat_id
     *
     * @param catId the value for t_goods.cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.extend_cat_id
     *
     * @return the value of t_goods.extend_cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getExtendCatId() {
        return extendCatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.extend_cat_id
     *
     * @param extendCatId the value for t_goods.extend_cat_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setExtendCatId(Integer extendCatId) {
        this.extendCatId = extendCatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_sn
     *
     * @return the value of t_goods.goods_sn
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_sn
     *
     * @param goodsSn the value for t_goods.goods_sn
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_name
     *
     * @return the value of t_goods.goods_name
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_name
     *
     * @param goodsName the value for t_goods.goods_name
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.click_count
     *
     * @return the value of t_goods.click_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.click_count
     *
     * @param clickCount the value for t_goods.click_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.brand_id
     *
     * @return the value of t_goods.brand_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.brand_id
     *
     * @param brandId the value for t_goods.brand_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.store_count
     *
     * @return the value of t_goods.store_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getStoreCount() {
        return storeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.store_count
     *
     * @param storeCount the value for t_goods.store_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setStoreCount(Short storeCount) {
        this.storeCount = storeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.comment_count
     *
     * @return the value of t_goods.comment_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.comment_count
     *
     * @param commentCount the value for t_goods.comment_count
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setCommentCount(Short commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.weight
     *
     * @return the value of t_goods.weight
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.weight
     *
     * @param weight the value for t_goods.weight
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.market_price
     *
     * @return the value of t_goods.market_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.market_price
     *
     * @param marketPrice the value for t_goods.market_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.shop_price
     *
     * @return the value of t_goods.shop_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.shop_price
     *
     * @param shopPrice the value for t_goods.shop_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.cost_price
     *
     * @return the value of t_goods.cost_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.cost_price
     *
     * @param costPrice the value for t_goods.cost_price
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.keywords
     *
     * @return the value of t_goods.keywords
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.keywords
     *
     * @param keywords the value for t_goods.keywords
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_remark
     *
     * @return the value of t_goods.goods_remark
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getGoodsRemark() {
        return goodsRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_remark
     *
     * @param goodsRemark the value for t_goods.goods_remark
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.original_img
     *
     * @return the value of t_goods.original_img
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getOriginalImg() {
        return originalImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.original_img
     *
     * @param originalImg the value for t_goods.original_img
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg == null ? null : originalImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_real
     *
     * @return the value of t_goods.is_real
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsReal() {
        return isReal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_real
     *
     * @param isReal the value for t_goods.is_real
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_on_sale
     *
     * @return the value of t_goods.is_on_sale
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsOnSale() {
        return isOnSale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_on_sale
     *
     * @param isOnSale the value for t_goods.is_on_sale
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_free_shipping
     *
     * @return the value of t_goods.is_free_shipping
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsFreeShipping() {
        return isFreeShipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_free_shipping
     *
     * @param isFreeShipping the value for t_goods.is_free_shipping
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsFreeShipping(Byte isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.on_time
     *
     * @return the value of t_goods.on_time
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getOnTime() {
        return onTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.on_time
     *
     * @param onTime the value for t_goods.on_time
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.sort
     *
     * @return the value of t_goods.sort
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.sort
     *
     * @param sort the value for t_goods.sort
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_recommend
     *
     * @return the value of t_goods.is_recommend
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsRecommend() {
        return isRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_recommend
     *
     * @param isRecommend the value for t_goods.is_recommend
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_new
     *
     * @return the value of t_goods.is_new
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsNew() {
        return isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_new
     *
     * @param isNew the value for t_goods.is_new
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.is_hot
     *
     * @return the value of t_goods.is_hot
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.is_hot
     *
     * @param isHot the value for t_goods.is_hot
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.last_update
     *
     * @return the value of t_goods.last_update
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.last_update
     *
     * @param lastUpdate the value for t_goods.last_update
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_type
     *
     * @return the value of t_goods.goods_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getGoodsType() {
        return goodsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_type
     *
     * @param goodsType the value for t_goods.goods_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.spec_type
     *
     * @return the value of t_goods.spec_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getSpecType() {
        return specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.spec_type
     *
     * @param specType the value for t_goods.spec_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSpecType(Short specType) {
        this.specType = specType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.give_integral
     *
     * @return the value of t_goods.give_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.give_integral
     *
     * @param giveIntegral the value for t_goods.give_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.exchange_integral
     *
     * @return the value of t_goods.exchange_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getExchangeIntegral() {
        return exchangeIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.exchange_integral
     *
     * @param exchangeIntegral the value for t_goods.exchange_integral
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setExchangeIntegral(Integer exchangeIntegral) {
        this.exchangeIntegral = exchangeIntegral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.suppliers_id
     *
     * @return the value of t_goods.suppliers_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.suppliers_id
     *
     * @param suppliersId the value for t_goods.suppliers_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.sales_sum
     *
     * @return the value of t_goods.sales_sum
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getSalesSum() {
        return salesSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.sales_sum
     *
     * @param salesSum the value for t_goods.sales_sum
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSalesSum(Integer salesSum) {
        this.salesSum = salesSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.prom_type
     *
     * @return the value of t_goods.prom_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Byte getPromType() {
        return promType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.prom_type
     *
     * @param promType the value for t_goods.prom_type
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setPromType(Byte promType) {
        this.promType = promType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.prom_id
     *
     * @return the value of t_goods.prom_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public Integer getPromId() {
        return promId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.prom_id
     *
     * @param promId the value for t_goods.prom_id
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.commission
     *
     * @return the value of t_goods.commission
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.commission
     *
     * @param commission the value for t_goods.commission
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.spu
     *
     * @return the value of t_goods.spu
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getSpu() {
        return spu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.spu
     *
     * @param spu the value for t_goods.spu
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSpu(String spu) {
        this.spu = spu == null ? null : spu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.sku
     *
     * @return the value of t_goods.sku
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getSku() {
        return sku;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.sku
     *
     * @param sku the value for t_goods.sku
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods.goods_content
     *
     * @return the value of t_goods.goods_content
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public String getGoodsContent() {
        return goodsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods.goods_content
     *
     * @param goodsContent the value for t_goods.goods_content
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent == null ? null : goodsContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods
     *
     * @mbg.generated Wed Oct 16 14:30:03 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", catId=").append(catId);
        sb.append(", extendCatId=").append(extendCatId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", weight=").append(weight);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsRemark=").append(goodsRemark);
        sb.append(", originalImg=").append(originalImg);
        sb.append(", isReal=").append(isReal);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", isFreeShipping=").append(isFreeShipping);
        sb.append(", onTime=").append(onTime);
        sb.append(", sort=").append(sort);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", specType=").append(specType);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", exchangeIntegral=").append(exchangeIntegral);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", salesSum=").append(salesSum);
        sb.append(", promType=").append(promType);
        sb.append(", promId=").append(promId);
        sb.append(", commission=").append(commission);
        sb.append(", spu=").append(spu);
        sb.append(", sku=").append(sku);
        sb.append(", goodsContent=").append(goodsContent);
        sb.append("]");
        return sb.toString();
    }
}