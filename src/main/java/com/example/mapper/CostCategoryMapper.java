package com.example.mapper;

import com.example.domain.CostCategory;
import com.example.example.CostCategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CostCategoryMapper {
	
    int countByExample(CostCategoryExample example);

    int deleteByExample(CostCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CostCategory record);

    int insertSelective(CostCategory record);

    List<CostCategory> selectByExample(CostCategoryExample example);

    CostCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CostCategory record, @Param("example") CostCategoryExample example);

    int updateByExample(@Param("record") CostCategory record, @Param("example") CostCategoryExample example);

    int updateByPrimaryKeySelective(CostCategory record);

    int updateByPrimaryKey(CostCategory record);
}