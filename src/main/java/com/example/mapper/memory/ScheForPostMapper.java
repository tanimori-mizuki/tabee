package com.example.mapper.memory;

import com.example.domain.memory.ScheForPost;
import com.example.example.memory.ScheForPostExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheForPostMapper {
 
    int countByExample(ScheForPostExample example);
  
    int deleteByExample(ScheForPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScheForPost record);

    int insertSelective(ScheForPost record);

    List<ScheForPost> selectByExample(ScheForPostExample example);

    ScheForPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheForPost record, @Param("example") ScheForPostExample example);

    int updateByExample(@Param("record") ScheForPost record, @Param("example") ScheForPostExample example);

    int updateByPrimaryKeySelective(ScheForPost record);

    int updateByPrimaryKey(ScheForPost record);
}