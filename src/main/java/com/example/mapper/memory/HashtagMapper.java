package com.example.mapper.memory;

import com.example.domain.memory.Hashtag;
import com.example.example.memory.HashtagExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HashtagMapper {
	
    int countByExample(HashtagExample example);

    int deleteByExample(HashtagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hashtag record);

    int insertSelective(Hashtag record);

    List<Hashtag> selectByExample(HashtagExample example);

    Hashtag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hashtag record, @Param("example") HashtagExample example);

    int updateByExample(@Param("record") Hashtag record, @Param("example") HashtagExample example);

    int updateByPrimaryKeySelective(Hashtag record);

    int updateByPrimaryKey(Hashtag record);
}