package com.example.service.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.memory.MemoryMapper;

/**
 * 思い出を削除するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class DeleteMemoryService {

	@Autowired
	private MemoryMapper memoryMapper;

	/**
	 * IDで思い出削除.
	 * 
	 * @param id 思い出ID
	 */
	public void deleteMemory(Integer id) {
		memoryMapper.deleteByPrimaryKey(id);
	}
}
