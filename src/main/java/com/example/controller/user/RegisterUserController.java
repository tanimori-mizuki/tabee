package com.example.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.User;
import com.example.form.user.RegisterUserForm;
import com.example.service.user.RegisterUserSevice;

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
	 * @throws Exception 
	 */
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterUserForm form) throws Exception {
		try {
			return registerUserService.registerUser(form);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
