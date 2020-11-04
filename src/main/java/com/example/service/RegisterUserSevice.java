package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.mapper.UserMapper;

//import com.example.domain.User;
//import com.example.form.RegisterUserForm;
//import com.example.mapper.UserMapper;

/**
 * ユーザー登録を行うサービスクラス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterUserSevice {

	@Autowired
	private UserMapper userMapper;

	/**
	 * ユーザー登録を行います.
	 * 
	 * @param form フォーム
	 * @return 登録ユーザー情報
	 */
	public User registerUser(RegisterUserForm form) {
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		
		return user;
		
////		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
////		user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
////
////		userMapper.insert(user);
////		User newUser = userMapper.findByEmail(form.getEmail());
////		
////		return newUser;
		
		
		
		
		

	}
}

