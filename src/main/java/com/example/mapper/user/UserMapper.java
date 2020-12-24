package com.example.mapper.user;

import com.example.domain.user.User;
import com.example.example.user.UserExample;

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
	
	/**
	 * メールアドレスとパスワードで1件検索.
	 * 
	 * @param email メールアドレス
	 * @param password　パスワード
	 * @return　.
	 */
	public User findByEmailAndPassword(String email, String password);

	/**
	 * ユーザーIDからユーザー情報を取得.
	 *
	 * @param userId ユーザーID
	 * @return ユーザー情報
	 */
	public User findByUserId(@Param("userId") Integer userId);

	public Integer updateUser(User user);

	/**
	 * ユーザーIDでユーザー情報を削除
	 *
	 * @param user　ユーザー
	 */
	public void deleteByUserId(User user);

	User selectByPrimaryKey(Integer id);

	
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	int updateByExampleSelective(@Param("user") User user, @Param("example") UserExample example);

	int updateByExample(@Param("user") User user, @Param("example") UserExample example);

	/**
	 * ユーザー情報(名前、アイコン画像)更新
	 *
	 * @param user
	 * @return
	 */
	public int updateByPrimaryKeySelective(User user);
	
}