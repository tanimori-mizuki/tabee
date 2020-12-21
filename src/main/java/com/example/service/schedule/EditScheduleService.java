package com.example.service.schedule;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.schedule.Schedule;
import com.example.form.schedule.EditScheduleForm;
import com.example.mapper.schedule.ScheduleMapper;

/**
 * スケジュールの更新を行うサービスクラス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class EditScheduleService {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	/**
	 * スケジュールを更新.
	 * 
	 * @param form
	 * @return 更新されたスケジュールデータ
	 */
	public Schedule updateSchedule(EditScheduleForm form) {
		Schedule schedule = new Schedule();
		Integer userId = Integer.parseInt(form.getUserId());
		Integer shioriId = Integer.parseInt(form.getShioriId());
		Integer id = Integer.parseInt(form.getId());
		
		schedule.setId(id);
		schedule.setTitle(form.getTitle());
		schedule.setStartAt(LocalDateTime.parse(form.getStartAt()));
		schedule.setFinishAt(LocalDateTime.parse(form.getFinishAt()));
		schedule.setIconPath(form.getIconPath());
		schedule.setShioriId(shioriId);
		schedule.setAddress(form.getAddress());
		schedule.setUrl(form.getUrl());
		schedule.setMemo(form.getMemo());
		schedule.setCost(Integer.parseInt(form.getCost()));
		schedule.setUpdaterId(userId);
		schedule.setUpdatedAt(LocalDateTime.now());
		schedule.setVersion(Integer.parseInt(form.getVersion()) +1);
		
		scheduleMapper.updateByPrimaryKeySelective(schedule);
		
		Schedule updatedSchedule = scheduleMapper.selectByPrimaryKey(id);
		return updatedSchedule;
	}

}
