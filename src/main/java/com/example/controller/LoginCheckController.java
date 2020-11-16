package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginCheckService;

/**
 * メールアドレスとパスワードが合っているか確認するコントローラ.
 * 
 * @author masashi.nose
 *
 */
@Controller
@RequestMapping("/user")
public class LoginCheckController {

	@Autowired
	private LoginCheckService loginCheckService;
	
	/**
	 * メールアドレスとパスワードが合っているか
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/loginCheck")
	public User loginCheck(@RequestBody LoginForm form) {
		return loginCheckService.findByEmailAndPassword(form.getEmail(), form.getPassword());
	}
	
}
