package com.example.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.schedule.ScheduleMapper;

/**
 * スケジュール情報を削除するサービスクラス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class DeleteScheduleService {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public void deleteSchedule(Integer scheduleId) {
		scheduleMapper.deleteByPrimaryKey(scheduleId);
	}

}
