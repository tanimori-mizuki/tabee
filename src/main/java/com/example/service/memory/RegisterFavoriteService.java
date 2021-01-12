package com.example.service.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Favorite;
import com.example.mapper.memory.FavoriteMapper;

/**
 * いいねするサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterFavoriteService {

	@Autowired
	private FavoriteMapper favoriteMapper;
	
	/**
	 * いいね登録.
	 * 
	 * @param favorite
	 */
	public void registerFavorite(Favorite favorite) {
		favoriteMapper.insert(favorite);
	}
}

