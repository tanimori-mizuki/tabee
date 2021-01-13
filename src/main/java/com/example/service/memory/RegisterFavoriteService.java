package com.example.service.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Favorite;
import com.example.domain.memory.Memory;
import com.example.example.memory.FavoriteExample;
import com.example.form.memory.RegisterFavoriteForm;
import com.example.mapper.memory.FavoriteMapper;
import com.example.mapper.memory.MemoryMapper;

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
	
	@Autowired
	private MemoryMapper memoryMapper;

	/**
	 * いいね登録 すでにいいね登録済みの場合は削除.
	 * 
	 * @param favorite
	 */
	public void registerFavorite(RegisterFavoriteForm form) {
		Integer memoryId = Integer.parseInt(form.getMemoryId());
		Integer userId = Integer.parseInt(form.getUserId());
		
		List<Memory> memoryList = memoryMapper.selectAll();
		for(Memory memory : memoryList) {
			System.out.println("service: " + memory.getFavoriteList());
		}

		FavoriteExample example = new FavoriteExample();
		example.createCriteria().andMemoryIdEqualTo(memoryId).andUserIdEqualTo(userId);

		List<Favorite> favoriteList = favoriteMapper.selectByExample(example);

		if (favoriteList.size() == 0) {
			Favorite favorite = new Favorite();
			favorite.setMemoryId(memoryId);
			favorite.setUserId(userId);
			favoriteMapper.insert(favorite);

		} else {
			favoriteMapper.deleteByExample(example);
		}
		
		
	}
}
