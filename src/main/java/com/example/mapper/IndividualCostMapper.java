package com.example.mapper;

import com.example.domain.IndividualCost;
import com.example.example.IndividualCostExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndividualCostMapper {
	
    int countByExample(IndividualCostExample example);

    int deleteByExample(IndividualCostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndividualCost record);

    int insertSelective(IndividualCost record);

    List<IndividualCost> selectByExample(IndividualCostExample example);

    IndividualCost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndividualCost record, @Param("example") IndividualCostExample example);

    int updateByExample(@Param("record") IndividualCost record, @Param("example") IndividualCostExample example);

    int updateByPrimaryKeySelective(IndividualCost record);

    int updateByPrimaryKey(IndividualCost record);
}