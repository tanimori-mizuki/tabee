package com.example.service.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memo.Memo;
import com.example.mapper.memo.MemoMapper;

/**
 * メモ情報を取得するサービス.
 * 
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetMemoService {

	@Autowired
	private MemoMapper memoMapper;

	/**
	 * 主キーからメモ情報を取得する.
	 * 
	 * @param memoId メモID
	 * @return メモ情報
	 */
	public Memo getMemo(Integer memoId) {
		return memoMapper.selectByPrimaryKey(memoId);
	}

}
