package com.example.mapper;

import com.example.domain.HadCostCategory;
import com.example.example.HadCostCategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HadCostCategoryMapper {
	
    int countByExample(HadCostCategoryExample example);
    
    int deleteByExample(HadCostCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HadCostCategory record);

    int insertSelective(HadCostCategory record);

    List<HadCostCategory> selectByExample(HadCostCategoryExample example);
    
    HadCostCategory selectByPrimaryKey(Integer id);

    
    int updateByExampleSelective(@Param("record") HadCostCategory record, @Param("example") HadCostCategoryExample example);

    
    int updateByExample(@Param("record") HadCostCategory record, @Param("example") HadCostCategoryExample example);

   
    int updateByPrimaryKeySelective(HadCostCategory record);

   
    int updateByPrimaryKey(HadCostCategory record);
}