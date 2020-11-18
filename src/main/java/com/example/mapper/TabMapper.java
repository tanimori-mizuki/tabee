package com.example.mapper;

import com.example.domain.Tab;
import com.example.example.TabExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(TabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(TabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(Tab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(Tab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<Tab> selectByExample(TabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    Tab selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") Tab record, @Param("example") TabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") Tab record, @Param("example") TabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(Tab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tabs
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(Tab record);
}