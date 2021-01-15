package com.example.mapper.memory;

import com.example.domain.memory.HadHashtag;
import com.example.example.memory.HadHashtagExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HadHashtagMapper {
    int countByExample(HadHashtagExample example);

    int deleteByExample(HadHashtagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HadHashtag record);

    int insertSelective(HadHashtag record);

    List<HadHashtag> selectByExample(HadHashtagExample example);

    HadHashtag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HadHashtag record, @Param("example") HadHashtagExample example);

    int updateByExample(@Param("record") HadHashtag record, @Param("example") HadHashtagExample example);

    int updateByPrimaryKeySelective(HadHashtag record);

    int updateByPrimaryKey(HadHashtag record);
}