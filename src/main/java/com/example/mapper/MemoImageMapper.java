package com.example.mapper;

import com.example.domain.MemoImage;
import com.example.example.MemoImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemoImageMapper {
	
    int countByExample(MemoImageExample example);

    int deleteByExample(MemoImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemoImage record);

    int insertSelective(MemoImage record);

    List<MemoImage> selectByExample(MemoImageExample example);

    MemoImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemoImage record, @Param("example") MemoImageExample example);

    int updateByExample(@Param("record") MemoImage record, @Param("example") MemoImageExample example);

    int updateByPrimaryKeySelective(MemoImage record);

    int updateByPrimaryKey(MemoImage record);
}