package com.example.service.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.example.memory.FavoriteExample;
import com.example.mapper.memory.FavoriteMapper;

/**
 * いいね削除サービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class DeleteFavoriteService {

	@Autowired
	private FavoriteMapper favoriteMapper;
	
	/**
	 * 思い出IDとユーザーIDに紐づく思い出を削除
	 * 
	 * @param memoryId 思い出ID
	 * @param userId　ユーザーID
	 */
	public void deleteFavorite(Integer memoryId, Integer userId) {
		FavoriteExample example = new FavoriteExample();
		example.createCriteria().andMemoryIdEqualTo(memoryId).andUserIdEqualTo(userId);
		
		favoriteMapper.deleteByExample(example);
		
	}
}
