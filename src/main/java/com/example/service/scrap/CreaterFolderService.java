package com.example.service.scrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.scrap.Scrap;
import com.example.mapper.scrap.ScrapMapper;

/**
 * スクラップのフォルダー作成サービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class CreaterFolderService {
	
	@Autowired
	private ScrapMapper scrapMapper;
	
	public Scrap createFolder() {
		
	}

}
