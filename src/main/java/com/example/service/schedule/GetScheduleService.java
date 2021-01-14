package com.example.service.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.schedule.Schedule;
import com.example.mapper.schedule.ScheduleMapper;

/**
 * スケジュール情報を取得する処理を行うサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class GetScheduleService {

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	/**
	 * しおりIDからスケジュール情報を取得
	 * 
	 * @param shioriId しおりID
	 * @return　しおりデータリスト
	 */
	public List<Schedule> getScheduleList(Integer userId){
		return scheduleMapper.selectByShioriId(userId);
	}
	
	/**
	 * スケジュールIDで1件取得
	 * 
	 * @param id スケジュールID
	 * @return　スケジュールデータ
	 */
	public Schedule getScheduleById(Integer id) {
		return scheduleMapper.selectByPrimaryKey(id);
		
	}
}
