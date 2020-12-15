package com.example.service.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.memo.MemoMapper;

/**
 * メモを削除する.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class DeleteMemoService {
	
	@Autowired
	private MemoMapper memoMapper;
	
	/**
	 * 主キーでメモ情報を削除する.
	 * 外部制約で連動してDB上のメモ画像も削除される.
	 * @param memoId
	 */
	public void deleteMemo(Integer memoId) {
		System.out.println("サービスの呼び出し");
		memoMapper.deleteByPrimaryKey(memoId);
	}

}
