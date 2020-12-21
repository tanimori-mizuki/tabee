package com.example.service.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.schedule.Schedule;
import com.example.domain.shiori.Shiori;
import com.example.domain.user.User;
import com.example.form.schedule.RegisterScheduleForm;
import com.example.mapper.schedule.ScheduleMapper;
import com.example.mapper.shiori.ShioriMapper;
import com.example.mapper.user.UserMapper;

/**
 * スケジュール登録処理を行うサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterScheduleService {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Autowired
	private ShioriMapper shioriMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * スケジュールを登録.
	 * 
	 * @param form
	 */
	public List<Schedule> registerSchedule(RegisterScheduleForm form) {
		Schedule schedule = new Schedule();
		Integer userId = Integer.parseInt(form.getUserId());
		Integer shioriId = Integer.parseInt(form.getShioriId());
		
		schedule.setTitle(form.getTitle());
		schedule.setStartAt(LocalDateTime.parse(form.getStartAt()));
		schedule.setFinishAt(LocalDateTime.parse(form.getFinishAt()));
		schedule.setIconPath(form.getIconPath());
		schedule.setShioriId(shioriId);
		schedule.setAddress(form.getAddress());
		schedule.setUrl(form.getUrl());
		schedule.setMemo(form.getMemo());
		schedule.setCost(Integer.parseInt(form.getCost()));
		schedule.setCreatorId(userId);
		schedule.setCreatedAt(LocalDateTime.now());
		schedule.setUpdaterId(userId);
		schedule.setUpdatedAt(LocalDateTime.now());
		schedule.setVersion(1);
		
		//スケジュール登録
		scheduleMapper.insertSelective(schedule);
		
		//自動採番IDで登録情報取得
//		Schedule registeredSchedule = scheduleMapper.selectByPrimaryKey(schedule.getId());
		List<Schedule> newScheduleList = scheduleMapper.selectByShioriId(userId);
		return newScheduleList;
		
//		Shiori shiori = shioriMapper.selectByPrimaryKey(shioriId);
//		registeredSchedule.setShiori(shiori);
//		
//		User user = userMapper.selectByPrimaryKey(userId);
//		registeredSchedule.setUser(user);
		
	}
	
}
