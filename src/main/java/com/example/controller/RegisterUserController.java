package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserSevice;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@PostMapping("/register")
	public String registerUser(@RequestBody String body) {
		System.out.println("called");
		System.out.println(body);
		
		return "success!";
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		try {
//			
//			User user = mapper.readValue(body, User.class);
//			System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getEmail());
//			String jsonData = mapper.writeValueAsString(registerUserService.registerUser(user));
//			System.out.println("json: " + jsonData);
//			return jsonData;
//		
//		}catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return null;
	}
}
