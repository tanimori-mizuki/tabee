package com.example.service.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memory.ScheForPost;
import com.example.mapper.memory.ScheForPostMapper;

/**
 * 投稿用スケジュールを登録するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterMemoryService {

	@Autowired
	private ScheForPostMapper scheForPostMapper;


}
