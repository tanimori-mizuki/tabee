package com.example.controller.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.memo.DeleteMemoService;

/**
 * メモの削除を行うコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/delete_memo")
public class DeleteMemoController {

	@Autowired
	private DeleteMemoService service;
	
	/**
	 * メモを削除する.
	 * @param memoId
	 */
	@GetMapping("")
	public void deleteMemo(Integer memoId) {
		service.deleteMemo(memoId);
		
	}
}
