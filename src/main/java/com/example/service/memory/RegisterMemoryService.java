package com.example.service.memory;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.Memory;
import com.example.form.memory.RegisterMemoryForm;
import com.example.mapper.memory.MemoryMapper;
import com.example.mapper.memory.ScheForPostMapper;

/**
 * 思い出を登録するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterMemoryService {

	@Autowired
	private ScheForPostMapper scheForPostMapper;

	@Autowired
	private MemoryMapper memoryMapper;

	/**
	 * 思い出を投稿.
	 * 
	 * @param memory 思い出情報.
	 */
	public void registerMemory(RegisterMemoryForm form) {
		System.out.println(form);
		
		Memory memory = new Memory();
		memory.setTitle(form.getTitle());
		memory.setContent(form.getContent());
		memory.setUserId(Integer.parseInt(form.getUserId()));
		memory.setPostAt(LocalDateTime.now());
		memory.setPublicSche(form.getIsPublicSche());
		memory.setShioriId(Integer.parseInt(form.getShioriId()));
		
		System.out.println(memory);
		
		memoryMapper.insertSelective(memory);
	}

}
