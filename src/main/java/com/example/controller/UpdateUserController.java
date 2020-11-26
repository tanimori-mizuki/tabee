package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.User;
import com.example.dto.ResetPassword;
import com.example.form.UpdatePasswordForm;
import com.example.service.UpdateUserService;

/**
 * ユーザー情報更新系のコントローラ.
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/user")
public class UpdateUserController {

	@Autowired
	private UpdateUserService updateUserService;

	
	@PostMapping("/checkEmail")
	public void sendResetPasswordMail(@RequestBody String email, ResetPassword resetPassword) {
		System.out.println("【メールアドレス】: " + email);
		
		updateUserService.registerResetPassword(resetPassword, email);
		updateUserService.sendResetPasswordMail(resetPassword, email);
		
		System.out.println("メール送信完了");
	}
	
	
	/**
	 * パスワードを更新.
	 * 
	 * @param form
	 */
	@PostMapping("/updatePassword")
	public void updatePassword(@RequestBody UpdatePasswordForm form) {
		updateUserService.UpdatePasswordById(form);
	}

}
