package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserSevice;

/**
 * ユーザー情報を登録するコントローラ.
 * 
 * @author masashi.nose
 *
 */
@Controller
@RequestMapping("/user")
public class RegisterUserController {
	
	@Autowired
	private RegisterUserSevice registerUserSevice;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterUserForm form) {
		return registerUserSevice.registerUser(form);
	}
	

}
