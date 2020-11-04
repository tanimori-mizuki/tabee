package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
//import com.example.domain.User;
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
	private RegisterUserSevice registerUserSevice;
	
	@CrossOrigin
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterUserForm form) {
		System.out.println("called");
		return registerUserSevice.registerUser(form);
	}
}
