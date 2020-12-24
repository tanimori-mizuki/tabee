package com.example.service.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.shiori.ShioriMapper;

/**
 * しおりを削除するサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class DeleteShioriService {

	@Autowired
	private ShioriMapper shioriMapper;
	
	/**
	 * しおりを削除する.
	 * @param shioriId しおりID
	 */
	public void deleteShiori(Integer shioriId) {
		shioriMapper.deleteByPrimaryKey(shioriId);
	}
}
