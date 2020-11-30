package com.example.service.memo;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.memo.Memo;
import com.example.form.RegisterMemoForm;
import com.example.mapper.memo.MemoMapper;

/**
 * メモ情報を登録するサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class RegisterMemoService {

	@Autowired
	private MemoMapper mapper;
	
	/**
	 * メモ情報を登録する.
	 * @return 成功件数
	 */
	public int registerMemo(RegisterMemoForm form) {	
		Memo memo=new Memo();
		BeanUtils.copyProperties(form, memo);
		memo.setCreatedAt(LocalDateTime.now());
		memo.setUpdaterId(form.getCreatorId());
		memo.setUpdatedAt(LocalDateTime.now());
		memo.setVersion(1);
		System.out.println("serviceのmemo"+memo);
		return mapper.insertSelective(memo);
	}
}
