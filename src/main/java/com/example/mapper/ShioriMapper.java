package com.example.mapper;

import com.example.domain.Shiori;
import com.example.example.ShioriExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShioriMapper {
	
    int countByExample(ShioriExample example);

    int deleteByExample(ShioriExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shiori record);

    int insertSelective(Shiori record);

    List<Shiori> selectByExample(ShioriExample example);

    Shiori selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shiori record, @Param("example") ShioriExample example);

    int updateByExample(@Param("record") Shiori record, @Param("example") ShioriExample example);

    int updateByPrimaryKeySelective(Shiori record);

    int updateByPrimaryKey(Shiori record);
}