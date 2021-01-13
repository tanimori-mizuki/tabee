package com.example.service.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Favorite;
import com.example.example.memory.FavoriteExample;
import com.example.form.memory.RegisterFavoriteForm;
import com.example.mapper.memory.FavoriteMapper;

/**
 * いいねする、またはいいね削除するサービス.
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
	 * いいね登録 すでにいいね登録済みの場合は削除.
	 * 
	 * @param favorite
	 */
	public void registerFavorite(RegisterFavoriteForm form) {
		Integer memoryId = Integer.parseInt(form.getMemoryId());
		Integer userId = Integer.parseInt(form.getUserId());

		FavoriteExample example = new FavoriteExample();
		example.createCriteria().andMemoryIdEqualTo(memoryId).andUserIdEqualTo(userId);

		List<Favorite> favoriteList = favoriteMapper.selectByExample(example);

		if (favoriteList.size() == 0) {
			Favorite favorite = new Favorite();
			favorite.setMemoryId(Integer.parseInt(form.getMemoryId()));
			favorite.setUserId(Integer.parseInt(form.getUserId()));
			favoriteMapper.insert(favorite);

		} else {
			favoriteMapper.deleteByExample(example);
		}
	}
}
