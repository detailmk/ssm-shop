package com.ego.mapper;

import com.ego.pojo.GoodsCategory;
import com.ego.pojo.GoodsCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    long countByExample(GoodsCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int deleteByExample(GoodsCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int deleteByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int insert(GoodsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int insertSelective(GoodsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    GoodsCategory selectByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int updateByExample(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int updateByPrimaryKeySelective(GoodsCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Tue Oct 15 08:49:53 CST 2019
     */
    int updateByPrimaryKey(GoodsCategory record);
}