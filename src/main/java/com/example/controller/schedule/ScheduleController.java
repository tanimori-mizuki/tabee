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
import com.example.form.schedule.EditScheduleForm;
import com.example.service.schedule.DeleteScheduleService;
import com.example.service.schedule.EditScheduleService;
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
	
	@Autowired
	private EditScheduleService editScheduleService;
	
	@Autowired
	private DeleteScheduleService deleteScheduleService;

	/**
	 * スケジュールを登録.
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
	
	/**
	 * スケジュールを編集.
	 * 
	 * @param form
	 * @return スケジュールデータ.
	 * @throws Exception バージョンが異なる場合例外発生
	 */
	@PostMapping("/edit")
	public Schedule editSchedule(@RequestBody EditScheduleForm form) throws Exception {
		Integer currentVersion = getScheduleService.getScheduleById(Integer.parseInt(form.getId())).getVersion();
		Integer inputVersion = Integer.parseInt(form.getVersion());
		if(currentVersion != inputVersion) {
			throw new Exception("編集中にデータが更新されました。");
		}
		
		return editScheduleService.updateSchedule(form);
	}
	
	/**
	 * スケジュールを削除
	 * 
	 * @param scheduleId　スケジュールID
	 * @return　確認メッセージ
	 */
	@GetMapping("/delete")
	public String deleteSchedule(Integer scheduleId) {
		System.out.println("【スケジュールID】: " + scheduleId);
		deleteScheduleService.deleteSchedule(scheduleId);
		return "deleted!";
		
	}
	
	
}
