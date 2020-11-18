package com.example.mapper;

import com.example.domain.CostCategory;
import com.example.example.CostCategoryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(CostCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(CostCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(CostCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(CostCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<CostCategory> selectByExample(CostCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    CostCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") CostCategory record, @Param("example") CostCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") CostCategory record, @Param("example") CostCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(CostCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cost_categories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(CostCategory record);
}