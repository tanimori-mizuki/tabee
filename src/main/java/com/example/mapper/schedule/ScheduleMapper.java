package com.example.mapper.schedule;

import com.example.domain.schedule.Schedule;
import com.example.example.schedule.ScheduleExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheduleMapper {

	/**
	 * しおりIDに紐づくスケジュールデータ取得
	 * 
	 * @param shioriId しおりID
	 * @return スケジュールデータリスト
	 */
	List<Schedule> selectByShioriId(@Param("userId") Integer userId);

	int countByExample(ScheduleExample example);

	int deleteByExample(ScheduleExample example);

	/**
	 * 主キーでスケジュールデータ削除
	 * 
	 * @param id スケジュールID
	 * @return　削除件数
	 */
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