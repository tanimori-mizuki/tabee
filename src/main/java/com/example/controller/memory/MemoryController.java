package com.example.controller.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.memory.Memory;
import com.example.domain.memory.ScheForPost;
import com.example.form.memory.EditMemoryScheduleForm;
import com.example.form.memory.RegisterMemoryForm;
import com.example.service.memory.EditMemoryScheduleService;
import com.example.service.memory.GetMemoryScheduleService;
import com.example.service.memory.RegisterMemoryService;

/**
 * 思い出投稿機能用API
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/memory")
public class MemoryController {

	@Autowired
	private GetMemoryScheduleService getMemoryScheduleService;

	@Autowired
	private RegisterMemoryService registerMemoryService;

	@Autowired
	private EditMemoryScheduleService editMemoryScheduleService;

	/**
	 * ユーザーIDに紐づくしおりIDから思い出投稿用スケジュールリストを取得.
	 * 
	 * @param userId ユーザーID
	 * @return
	 */
	@GetMapping("/getMemoryScheduleList")
	public List<ScheForPost> getMemoryScheduleList(Integer userId) {
		System.out.println(userId);
		return getMemoryScheduleService.getMemoryScheduleList(userId);
	}

	/**
	 * 思い出投稿用スケジュールを編集.
	 * 
	 * @param form 
	 */
	@PostMapping("/editSchedule")
	public void editMemorySchedule(@RequestBody EditMemoryScheduleForm form) {
		System.out.println("edit called!");
		System.out.println(form);
		editMemoryScheduleService.editMemorySchedule(form);
	}

	/**
	 * 思い出を投稿.
	 * 
	 * @param memory 思い出情報
	 */
	@PostMapping("/post")
	public void postMemory(@RequestBody RegisterMemoryForm form) {
		System.out.println(form);
		registerMemoryService.registerMemory(form);

	}

}
