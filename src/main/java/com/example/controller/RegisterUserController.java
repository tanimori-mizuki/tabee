package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.User;
import com.example.form.LoginForm;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserSevice;

/**
 * ユーザー情報を登録するコントローラ.
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/user")
public class RegisterUserController {

	@Autowired
	private RegisterUserSevice registerUserService;

	/**
	 * ユーザー登録.
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterUserForm form) {
		return registerUserService.registerUser(form);

	}

}
