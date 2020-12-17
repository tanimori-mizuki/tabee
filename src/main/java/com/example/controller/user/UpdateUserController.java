package com.example.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.ResetPassword;
import com.example.domain.user.User;
import com.example.form.user.CheckEmailForm;
import com.example.form.user.UpdateEmailForm;
import com.example.form.user.UpdatePasswordForm;
import com.example.service.user.UpdateUserService;


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
	public User sendResetPasswordMail(@RequestBody CheckEmailForm form, ResetPassword resetPassword) throws Exception {
		
		try {

			User user = updateUserService.registerResetPassword(resetPassword, form.getEmail());
			updateUserService.sendResetPasswordMail(resetPassword, form.getEmail());
			
			return user;
			
			
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
	public void updatePassword(@RequestBody UpdatePasswordForm form) {
		updateUserService.UpdatePassword(form);
	}
	
	/**
	 * メールアドレスを更新
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/updateEmail")
	public User updateEmail(@RequestBody UpdateEmailForm form) throws Exception {
		try {
			return updateUserService.UpdateEmail(form);
			
		}catch (Exception e) {
			throw new UsernameNotFoundException("メールアドレス更新処理が正常に行われませんでした。");
		}
	}
}
