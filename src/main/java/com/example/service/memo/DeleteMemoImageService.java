package com.example.service.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.memo.MemoImageMapper;

/**
 * メモ画像の削除を行うサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class DeleteMemoImageService {
	
	@Autowired
	private MemoImageMapper memoImageMapper;
	
	/**
	 *主キーから メモ画像を削除する
	 * @param memoImageId メモ画像ID
	 */
	public void deleteMemoImage(Integer memoImageId) {
		System.out.println(memoImageId);
		memoImageMapper.deleteByPrimaryKey(memoImageId);
	}

}
