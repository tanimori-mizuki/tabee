package com.example.mapper;

import com.example.domain.CategoryContent;
import com.example.example.CategoryContentExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryContentMapper {
    
	int countByExample(CategoryContentExample example);

    int deleteByExample(CategoryContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryContent record);

    int insertSelective(CategoryContent record);

    List<CategoryContent> selectByExample(CategoryContentExample example);

    CategoryContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryContent record, @Param("example") CategoryContentExample example);

    int updateByExample(@Param("record") CategoryContent record, @Param("example") CategoryContentExample example);

    int updateByPrimaryKeySelective(CategoryContent record);

    int updateByPrimaryKey(CategoryContent record);
}