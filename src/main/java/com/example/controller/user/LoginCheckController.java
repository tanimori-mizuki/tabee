package com.example.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.User;
import com.example.form.user.LoginForm;
import com.example.service.user.LoginCheckService;

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
		return loginCheckService.findByEmailAndPassword(form.getEmail(), form.getPassword());
	}
}
