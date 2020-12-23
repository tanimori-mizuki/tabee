package com.example.mapper.memory;

import com.example.domain.memory.Memory;
import com.example.example.memory.MemoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemoryMapper {
	int countByExample(MemoryExample example);

	int deleteByExample(MemoryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Memory record);

	/**
	 * 思い出を投稿.
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(Memory record);

	List<Memory> selectByExample(MemoryExample example);

	Memory selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Memory record, @Param("example") MemoryExample example);

	int updateByExample(@Param("record") Memory record, @Param("example") MemoryExample example);

	int updateByPrimaryKeySelective(Memory record);

	int updateByPrimaryKey(Memory record);
}