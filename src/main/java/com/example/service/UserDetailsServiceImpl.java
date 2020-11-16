package com.example.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.mapper.UserMapper;

/**
 * 
 * ログイン後のuser情報に権限情報を付与するサービスクラス.
 * 
 * @author masashi.nose
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	/*
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String) DBから検索をし、ログイン情報を構成して返す。
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		com.example.domain.User user = userMapper.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("そのメールアドレスは登録されていません。");
			
		}
		
		//権限付与
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails loginUser = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(authorityList).build();

		return loginUser;
	}
}
