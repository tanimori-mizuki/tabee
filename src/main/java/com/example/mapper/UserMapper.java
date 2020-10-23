package com.example.mapper;

import com.example.domain.User;
import com.example.domain.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

	/**
	 * ユーザー情報を登録します.
	 * 
	 * @param user ユーザー情報
	 * 
	 */
	public Integer insert(User user);

	
	int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    
    int deleteByPrimaryKey(Long id);

  
    int insertSelective(User record);

  
    List<User> selectByExample(UserExample example);

  
    User selectByPrimaryKey(Long id);

  
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

  
    int updateByPrimaryKeySelective(User record);

 
    int updateByPrimaryKey(User record);
}