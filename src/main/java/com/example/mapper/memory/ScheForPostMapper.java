package com.example.mapper.memory;

import com.example.domain.memory.ScheForPost;
import com.example.example.memory.ScheForPostExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheForPostMapper {

	/**
	 * ユーザーが属するしおりIDから投稿用スケジュールリストを取得.
	 * 
	 * @param userId ユーザーID
	 * @return　しおり情報リスト
	 */
	public List<ScheForPost> selectByShioriId(@Param("userId") Integer userId);

	int countByExample(ScheForPostExample example);

	int deleteByExample(ScheForPostExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ScheForPost record);

	/**
	 * スケジュール登録時に投稿用スケジュールテーブルにもインサート.
	 * 
	 * @param record スケジュールデータ
	 * @return 登録件数
	 */
	int insertSelective(ScheForPost record);

	List<ScheForPost> selectByExample(ScheForPostExample example);

	ScheForPost selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ScheForPost record, @Param("example") ScheForPostExample example);

	int updateByExample(@Param("record") ScheForPost record, @Param("example") ScheForPostExample example);

	/**
	 * スケジュール更新時にスケジュールIDで紐づいた投稿用スケジュールテーブルも更新.
	 * 
	 * @param record 投稿用スケジュールデータ
	 * @return 更新件数
	 */
	int updateByPrimaryKeySelective(ScheForPost record);

	int updateByPrimaryKey(ScheForPost record);
}