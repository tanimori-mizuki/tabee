package com.example.service.schedule;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.domain.memory.ScheForPost;
import com.example.domain.schedule.Schedule;
import com.example.form.schedule.EditScheduleForm;
import com.example.mapper.memory.ScheForPostMapper;
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
	
	@Autowired
	private ScheForPostMapper scheForPostMapper;
	
	/**
	 * スケジュールを更新.
	 * 思い出投稿用スケジュールも更新
	 * 
	 * @param form
	 * @return 更新されたスケジュールデータ
	 */
	public Schedule updateSchedule(EditScheduleForm form) {
		System.out.println("サービス " + form);
		Schedule schedule = new Schedule();
		Integer userId = Integer.parseInt(form.getUserId());
		Integer shioriId = Integer.parseInt(form.getShioriId());
		Integer id = Integer.parseInt(form.getId());
		
		schedule.setId(id);
		schedule.setTitle(form.getTitle());
		
		if(!ObjectUtils.isEmpty(form.getStartAt())) {
			schedule.setStartAt(LocalDateTime.parse(form.getStartAt()));
		}else {
			schedule.setStartAt(null);
		}
		
		if(!ObjectUtils.isEmpty(form.getFinishAt())) {
			schedule.setFinishAt(LocalDateTime.parse(form.getFinishAt()));
		}else {
			schedule.setFinishAt(null);
		}
		
		schedule.setIconPath(form.getIconPath());
		schedule.setShioriId(shioriId);
		schedule.setAddress(form.getAddress());
		schedule.setUrl(form.getUrl());
		schedule.setMemo(form.getMemo());
		
		if (ObjectUtils.isEmpty(form.getCost())) {
			schedule.setCost(null);
		}else {
			schedule.setCost(Integer.parseInt(form.getCost()));
		}
		
		schedule.setUpdaterId(userId);
		schedule.setUpdatedAt(LocalDateTime.now());
		schedule.setVersion(Integer.parseInt(form.getVersion()) +1);
		System.out.println("formから詰められたschedule" + schedule);
		
		scheduleMapper.updateByPrimaryKeySelective(schedule);
		Schedule updatedSchedule = scheduleMapper.selectByPrimaryKey(id);
		
		ScheForPost scheForPost = new ScheForPost();
		BeanUtils.copyProperties(updatedSchedule, scheForPost);
		scheForPost.setScheduleId(updatedSchedule.getId());
		
		scheForPostMapper.updateByPrimaryKeySelective(scheForPost);
		
		return updatedSchedule;
	}

}
