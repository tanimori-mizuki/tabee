package com.example.service.memory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Memory;
import com.example.mapper.memory.MemoryMapper;

/**
 * 思い出情報取得するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class GetMemoryService {

	@Autowired
	private MemoryMapper memoryMapper;

	/**
	 * 思い出全件取得.
	 * 
	 * @return 思い出リスト.
	 */
	public List<Memory> findAllMemories() {
		return memoryMapper.selectAll();
	}

	/**
	 * ユーザーIDに紐づく思い出全件取得.
	 * 
	 * @param userId　ユーザーID
	 * @return　思い出リスト.
	 */
	public List<Memory> findAllMemoriesByUserId(Integer userId) {
		return memoryMapper.selectByUserId(userId);
	}

}
