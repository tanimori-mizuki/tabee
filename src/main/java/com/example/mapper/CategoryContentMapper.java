package com.example.mapper;

import com.example.domain.CategoryContent;
import com.example.example.CategoryContentExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(CategoryContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(CategoryContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(CategoryContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(CategoryContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<CategoryContent> selectByExample(CategoryContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    CategoryContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") CategoryContent record, @Param("example") CategoryContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") CategoryContent record, @Param("example") CategoryContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(CategoryContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category_contents
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(CategoryContent record);
}