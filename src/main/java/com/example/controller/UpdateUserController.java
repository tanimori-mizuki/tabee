package com.example.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.ResetPassword;
import com.example.form.CheckEmailForm;
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

	
	/**
	 * パスワード変更時のメールアドレスチェック
	 * チェックOKであればユーザー宛にメール送信
	 * 
	 * @param form
	 * @param resetPassword
	 * @throws Exception 
	 */
	@PostMapping("/checkEmail")
	public void sendResetPasswordMail(@RequestBody CheckEmailForm form, ResetPassword resetPassword) throws Exception {
		
		try {

			updateUserService.registerResetPassword(resetPassword, form.getEmail());
			updateUserService.sendResetPasswordMail(resetPassword, form.getEmail());
			
			
		}catch (Exception e) {
		
			throw new Exception();
		
		}
	}
	
	/**
	 * パスワードを更新.
	 * 
	 * @param form
	 */
	@PostMapping("/updatePassword")
	public void updatePassword(@RequestBody UpdatePasswordForm form, ResetPassword resetPassword, HttpServletRequest req) {
		System.out.println("controller called!");
		System.out.println("【controllerでのform】: "+ form);
		updateUserService.UpdatePasswordById(form, resetPassword, req);
	}

}
