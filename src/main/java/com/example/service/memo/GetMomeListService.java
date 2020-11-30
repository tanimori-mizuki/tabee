package com.example.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memo.Memo;
import com.example.mapper.memo.MemoMapper;

/**
 * メモ情報を取得するサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetMomeListService {

	@Autowired
	private MemoMapper mapper;
	
	/**
	 * メモリストを取得する.
	 * @param shioriId　しおりID
	 * @return　メモリスト
	 */
	public List<Memo> getMemoList(Integer shioriId){
		List <Memo> memoList=mapper.selectByshioriId(shioriId);
		if(memoList.size()==0) {
			return null;
		}
		return memoList;
	}
}
