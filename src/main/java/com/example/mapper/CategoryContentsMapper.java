package com.example.mapper;

import com.example.domain.CategoryContent;
import com.example.example.CategoryContentsExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryContentsMapper {
    
	int countByExample(CategoryContentsExample example);

    int deleteByExample(CategoryContentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryContent record);

    int insertSelective(CategoryContent record);

    List<CategoryContent> selectByExample(CategoryContentsExample example);

    CategoryContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryContent record, @Param("example") CategoryContentsExample example);

    int updateByExample(@Param("record") CategoryContent record, @Param("example") CategoryContentsExample example);

    int updateByPrimaryKeySelective(CategoryContent record);

    int updateByPrimaryKey(CategoryContent record);
}