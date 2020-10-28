package com.example.mapper;

import com.example.domain.MemoryImage;
import com.example.example.MemoryImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemoryImagesMapper {
	
    int countByExample(MemoryImageExample example);

    int deleteByExample(MemoryImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemoryImage record);

    int insertSelective(MemoryImage record);

    List<MemoryImage> selectByExample(MemoryImageExample example);

    MemoryImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemoryImage record, @Param("example") MemoryImageExample example);

    int updateByExample(@Param("record") MemoryImage record, @Param("example") MemoryImageExample example);

    int updateByPrimaryKeySelective(MemoryImage record);

    int updateByPrimaryKey(MemoryImage record);
}