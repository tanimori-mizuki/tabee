package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.example.UserExample;
import com.example.mapper.UserMapper;

/**
 * ログインチェックするサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class LoginCheckService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * メールアドレスとパスワードが合っているか確認.
	 * 
	 * @param email　メールアドレス
	 * @param password　パスワード
	 * @return
	 */
	public User findByEmailAndPassword(String email, String password) {
		User user = userMapper.findByEmail(email);
		
		if(user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
			return user;
		
		}else {
			return null;
		}
	}
}
