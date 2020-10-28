package com.example.mapper;

import com.example.domain.Read;
import com.example.example.ReadExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReadMapper {
    
	int countByExample(ReadExample example);

    int deleteByExample(ReadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Read record);

    int insertSelective(Read record);

    List<Read> selectByExample(ReadExample example);

    Read selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Read record, @Param("example") ReadExample example);

    int updateByExample(@Param("record") Read record, @Param("example") ReadExample example);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);
}