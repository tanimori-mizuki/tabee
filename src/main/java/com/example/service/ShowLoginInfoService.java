package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.User;
import com.example.mapper.user.UserMapper;

/**
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class ShowLoginInfoService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * メールアドレスでユーザー検索.
	 * 
	 * @param email メールアドレス
	 * @return
	 */
	public User showLoginUser(String email) {
		return userMapper.findByEmail(email);
	}
}
