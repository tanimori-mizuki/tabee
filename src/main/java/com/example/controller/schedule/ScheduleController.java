package com.example.controller.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.schedule.Schedule;
import com.example.form.schedule.RegisterScheduleForm;
import com.example.service.schedule.GetScheduleService;
import com.example.service.schedule.RegisterScheduleService;

/**
 * スケジュール処理周りのコントローラ.
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private RegisterScheduleService registerScheduleService;

	@Autowired
	private GetScheduleService getScheduleService;

	/**
	 * スケジュール登録.
	 * 
	 * @param form
	 * @return 登録したスケジュールデータ
	 */
	@PostMapping("/register")
	public List<Schedule> registerSchedule(@RequestBody RegisterScheduleForm form) {
		return registerScheduleService.registerSchedule(form);
	}

	/**
	 * しおりIDでスケジュールデータ取得
	 * 
	 * @param shioriId しおりID
	 * @return スケジュールデータリスト
	 */
	@GetMapping("/getScheduleList")
	public List<Schedule> getScheduleByShioriId(Integer userId) {
		System.out.println("【ユーザーID】:　" + userId);
		List<Schedule> scheduleList = getScheduleService.getScheduleList(userId);
		return scheduleList;
	}
}
