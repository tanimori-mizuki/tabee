package com.example.service.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.ScheForPost;
import com.example.mapper.memory.ScheForPostMapper;

/**
 * 投稿用スケジュールを取得するサービスクラス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class GetMemoryScheduleService {

	@Autowired
	private ScheForPostMapper scheForPostMapper;

	/**
	 * ユーザーが属するしおりIDから投稿用スケジュールリストを取得.
	 * 
	 * @param userId ユーザーID
	 * @return 投稿用スケジューリスト
	 */
	public List<ScheForPost> getMemoryScheduleList(Integer userId) {
		return scheForPostMapper.selectByShioriId(userId);
	}
}
