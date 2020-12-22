package com.example.service.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.domain.memory.ScheForPost;
import com.example.domain.schedule.Schedule;
import com.example.form.schedule.RegisterScheduleForm;
import com.example.mapper.memory.ScheForPostMapper;
import com.example.mapper.schedule.ScheduleMapper;

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
	private ScheForPostMapper scheForPostMapper;

	/**
	 * スケジュールを登録.
	 * 
	 * @param form
	 */
	public List<Schedule> registerSchedule(RegisterScheduleForm form) {
		Schedule schedule = new Schedule();
		ScheForPost scheForPost = new ScheForPost();
		Integer userId = Integer.parseInt(form.getUserId());
		Integer shioriId = Integer.parseInt(form.getShioriId());

		schedule.setTitle(form.getTitle());

		if (!ObjectUtils.isEmpty(form.getStartAt())) {
			schedule.setStartAt(LocalDateTime.parse(form.getStartAt()));
		}

		if (!ObjectUtils.isEmpty(form.getFinishAt())) {
			schedule.setFinishAt(LocalDateTime.parse(form.getFinishAt()));
		}

		schedule.setIconPath(form.getIconPath());
		schedule.setShioriId(shioriId);
		schedule.setAddress(form.getAddress());
		schedule.setUrl(form.getUrl());
		schedule.setTel(form.getTel());
		schedule.setMemo(form.getMemo());

		if (!ObjectUtils.isEmpty(form.getCost())) {
			schedule.setCost(Integer.parseInt(form.getCost()));
		}

		schedule.setCreatorId(userId);
		schedule.setCreatedAt(LocalDateTime.now());
		schedule.setUpdaterId(userId);
		schedule.setUpdatedAt(LocalDateTime.now());
		schedule.setVersion(1);

		//投稿用スケジュールにコピー
		BeanUtils.copyProperties(schedule, scheForPost);
		
		// スケジュール登録
		scheduleMapper.insertSelective(schedule);

		// 自動採番IDで登録情報取得
		Schedule registeredSchedule = scheduleMapper.selectByPrimaryKey(schedule.getId());
		
		//投稿用スケジュール登録
		scheForPost.setScheduleId(registeredSchedule.getId());
		scheForPostMapper.insertSelective(scheForPost);
		
		List<Schedule> newScheduleList = scheduleMapper.selectByShioriId(userId);
		return newScheduleList;

	}

}
