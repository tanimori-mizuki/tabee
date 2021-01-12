package com.example.service.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Favorite;
import com.example.domain.memory.Memory;
import com.example.form.memory.RegisterFavoriteForm;
import com.example.mapper.memory.FavoriteMapper;
import com.example.mapper.memory.MemoryMapper;

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
	
	@Autowired
	private MemoryMapper memoryMapper;
	
	/**
	 * いいね登録.
	 * 
	 * @param favorite
	 */
	public void registerFavorite(RegisterFavoriteForm form) {
		Favorite favorite = new Favorite();
		favorite.setMemoryId(Integer.parseInt(form.getMemoryId()));
		favorite.setUserId(Integer.parseInt(form.getUserId()));
		favoriteMapper.insert(favorite);
		
		List<Memory> memoryList = memoryMapper.selectAll();
		for(Memory memory: memoryList) {
			System.out.println(memory.getId() + ": " + memory.getFavoriteList().size());
		}
		
		
	}
}

