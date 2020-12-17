package com.example.service.schedule;

import java.util.ArrayList;
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
		System.out.println(userId);
		List<Schedule> scheduleList = scheduleMapper.selectByShioriId(userId);
		System.out.println(scheduleList);
		if(scheduleList.size() == 0) {
			System.out.println("size = 0");
		}
		return scheduleList;
	}
}
