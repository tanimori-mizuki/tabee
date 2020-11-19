package com.example.mapper;

import com.example.domain.Schedule;
import com.example.example.ScheduleExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleMapper {
 
    int countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);
  
    int deleteByPrimaryKey(Integer id);
 
    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExampleWithBLOBs(ScheduleExample example);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExampleWithBLOBs(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKeyWithBLOBs(Schedule record);

    int updateByPrimaryKey(Schedule record);
}