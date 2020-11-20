package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.User;
import com.example.form.RegisterUserForm;
import com.example.mapper.user.UserMapper;


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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		String encodedPassword = passwordEncoder.encode(form.getPassword());
		user.setPassword(encodedPassword);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		
		userMapper.insert(user);
		
		User newUser = userMapper.findByEmail(form.getEmail());
		
		return newUser;
		
	}
}

