package com.example.mapper;

import com.example.domain.Memories;
import com.example.domain.MemoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int countByExample(MemoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByExample(MemoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insert(Memories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int insertSelective(Memories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    List<Memories> selectByExample(MemoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    Memories selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") Memories record, @Param("example") MemoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByExample(@Param("record") Memories record, @Param("example") MemoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKeySelective(Memories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memories
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    int updateByPrimaryKey(Memories record);
}