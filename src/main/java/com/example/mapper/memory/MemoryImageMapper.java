package com.example.mapper.memory;

import com.example.domain.memory.MemoryImage;
import com.example.example.memory.MemoryImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemoryImageMapper {

	/**
	 * 思い出画像を一括挿入.
	 * 
	 * @param memoryImageList
	 * @return
	 */
	public int insertMemoryImageList(@Param("memoryImageList") List<MemoryImage> memoryImageList);

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