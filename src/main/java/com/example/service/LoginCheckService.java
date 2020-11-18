package com.example.service;

import java.util.List;

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
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @return
	 */
	public User findByEmailAndPassword(String email, String password) {

		System.out.println("----------ログインチェックサービス到達----------");
		
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);

		List<User> userList = userMapper.selectByExample(example);
		User user = userList.get(0);
		System.out.println("【メルアドで1件検索結果】" + user);

		if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
			System.out.println("【メルアド＆パスワード一致】");
			return user;
			
		} else {
			System.out.println("email & passoword NOT matched!");
			User holdUser = new User();
			holdUser.setId(0);
			
			return holdUser;
		}

	}
}
