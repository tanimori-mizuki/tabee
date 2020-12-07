package com.example.service.scrap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.scrap.Scrap;
import com.example.form.scrap.CreateFolderForm;
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
	
	/**
	 * フォルダー名を受け取ってscrapテーブルにインサートするメソッド.
	 * 
	 * @param form　
	 * @return インサートされたスクラップ情報
	 */
	public List<Scrap> createFolder(CreateFolderForm form) {
		
		System.out.println("フォルダー名：" + form.getFolderName());
		
		// スクラップに値をセット
		Scrap scrap = new Scrap();
		scrap.setShioriId(1);
		scrap.setName(form.getFolderName());
		scrap.setCreatorId(7);
		scrap.setCreatedAt(new Date());
		scrap.setUpdaterId(7);
		scrap.setUpdatedAt(new Date());
		scrap.setVersion(1); 	// 初期装備
		
		// 日付の確認用ログ
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(scrap.getCreatedAt());
		System.out.println("登録日" + date);
		
		// scrapテーブルにインサート
		scrapMapper.insertSelective(scrap);
		
		List<Scrap> scrapList = scrapMapper.findAll();
		
		return scrapList;
		
	}

}
