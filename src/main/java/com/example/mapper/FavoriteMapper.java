package com.example.mapper;

import com.example.domain.Favorite;
import com.example.example.FavoriteExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoriteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(FavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(FavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(Favorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(Favorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<Favorite> selectByExample(FavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    Favorite selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(Favorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(Favorite record);
}