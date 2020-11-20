package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.User;
import com.example.form.LoginForm;
import com.example.service.LoginCheckService;

/**
 * メールアドレスとパスワードが合っているか確認するコントローラ.
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/user")
public class LoginCheckController {

	@Autowired
	private LoginCheckService loginCheckService;
	
	/**
	 * メールアドレスとパスワードが合っているか
	 * 
	 * @param form　フォーム
	 * @return
	 */
	@PostMapping("/loginCheck")
	public User loginCheck(@RequestBody LoginForm form) {
		System.out.println("----------ログインチェックコントローラ到達----------");
		System.out.println("【Formのメルアド】" + form.getEmail());
		System.out.println("【Formのパスワード】" + form.getPassword());
		
		User user = loginCheckService.findByEmailAndPassword(form.getEmail(), form.getPassword());
		System.out.println("【検索されたユーザー結果】：" + user);
//		return loginCheckService.findByEmailAndPassword(form.getEmail(), form.getPassword());
		return user;
	}
	
}
