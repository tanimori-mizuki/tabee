package com.example.mapper;

import com.example.domain.ScheduleIcon;
import com.example.example.ScheduleIconExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheduleIconMapper {
    
	int countByExample(ScheduleIconExample example);

    int deleteByExample(ScheduleIconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleIcon record);

    int insertSelective(ScheduleIcon record);

    List<ScheduleIcon> selectByExample(ScheduleIconExample example);

    ScheduleIcon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheduleIcon record, @Param("example") ScheduleIconExample example);

    int updateByExample(@Param("record") ScheduleIcon record, @Param("example") ScheduleIconExample example);

    int updateByPrimaryKeySelective(ScheduleIcon record);

    int updateByPrimaryKey(ScheduleIcon record);
}