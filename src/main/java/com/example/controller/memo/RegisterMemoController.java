package com.example.controller.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.RegisterMemoForm;
import com.example.service.memo.RegisterMemoService;

/**
 * メモ登録処理を行うコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/register_memo")
public class RegisterMemoController {

	@Autowired
	private RegisterMemoService registerMemoService;
	
	/**
	 * メモ情報を登録する.
	 * @param form
	 */
	@PostMapping("/do")
	public void registerMemo(@RequestBody RegisterMemoForm form) {
		//画像アップロードは後日追加
		System.out.println("controller"+form);
		registerMemoService.registerMemo(form);
	}
	
}
