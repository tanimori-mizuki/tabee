package com.example.controller.memory;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.memory.Memory;
import com.example.domain.memory.ScheForPost;
import com.example.form.memory.EditMemoryScheduleForm;
import com.example.form.memory.RegisterFavoriteForm;
import com.example.form.memory.RegisterMemoryForm;
import com.example.service.memory.DeleteMemoryService;
import com.example.service.memory.EditMemoryScheduleService;
import com.example.service.memory.GetMemoryScheduleService;
import com.example.service.memory.GetMemoryService;
import com.example.service.memory.RegisterFavoriteService;
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

	@Autowired
	private GetMemoryService getMemoryService;

	@Autowired
	private DeleteMemoryService deleteMemoryService;
	
	@Autowired
	private RegisterFavoriteService registerFavoriteService;

	/**
	 * ユーザーIDに紐づくしおりIDから思い出投稿用スケジュールリストを取得.
	 * 
	 * @param userId ユーザーID
	 * @return
	 */
	@GetMapping("/getMemoryScheduleList")
	public List<ScheForPost> getMemoryScheduleList(Integer userId) {
		return getMemoryScheduleService.getMemoryScheduleList(userId);
	}

	/**
	 * 思い出投稿用スケジュールを編集.
	 * 
	 * @param form
	 */
	@PostMapping("/editSchedule")
	public void editMemorySchedule(@RequestBody EditMemoryScheduleForm form) {
		editMemoryScheduleService.editMemorySchedule(form);
	}

	/**
	 * 思い出を投稿.
	 * 
	 * @param memory 思い出情報
	 */
	@PostMapping("/post")
	public void postMemory(@RequestPart("memory") RegisterMemoryForm form,
			@RequestParam(value = "file", required = false) List<MultipartFile> uploadFileList) throws Exception {
		registerMemoryService.registerMemory(form, uploadFileList);

	}

	/**
	 * 思い出を全件取得.
	 * 
	 * @return 思い出リスト
	 * @throws IOException
	 */
	@GetMapping("/getMemories")
	public List<Memory> getMemoryList() throws IOException {
		List<Memory> memoryList = getMemoryService.findAllMemories();
		
		if(memoryList.size() != 0) {
			for(Memory memory : memoryList) {
				System.out.println("fav list" + memory.getFavoriteList());
			}
		}
		
		return getMemoryService.findAllMemories();
	}

	/**
	 * 思い出を削除.
	 * 
	 * @param id ID
	 */
	@GetMapping("/deleteMemory")
	public void deleteMemory(Integer id) {
		deleteMemoryService.deleteMemory(id);
	}
	
	/**
	 * いいねを登録/削除.
	 * 
	 * @param form
	 */
	@PostMapping("/favorite")
	public void favorite(@RequestBody RegisterFavoriteForm form) {
		registerFavoriteService.registerFavorite(form);
	}
}
