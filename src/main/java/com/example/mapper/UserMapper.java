package com.example.mapper;

import com.example.domain.User;
import com.example.example.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

	/**
	 * ユーザー登録.
	 * 
	 * @param user ユーザー情報
	 * @return 
	 */
	public int insert(User user);
	
	/**
	 * 
	 * メールアドレスで1件検索
	 * 
	 * @param email メールアドレス
	 * @return
	 */
	public User findByEmail(String email);

	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}