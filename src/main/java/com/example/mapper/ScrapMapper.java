package com.example.mapper;

import com.example.domain.Scrap;
import com.example.example.ScrapExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScrapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(ScrapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(ScrapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(Scrap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(Scrap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<Scrap> selectByExample(ScrapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    Scrap selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") Scrap record, @Param("example") ScrapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") Scrap record, @Param("example") ScrapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(Scrap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scraps
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(Scrap record);
}