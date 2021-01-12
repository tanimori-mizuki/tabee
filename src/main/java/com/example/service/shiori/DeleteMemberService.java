package com.example.service.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.example.shiori.MemberExample;
import com.example.form.shiori.DeleteMemberForm;
import com.example.mapper.shiori.MemberMapper;

/**
 * メンバーの削除を行うサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class DeleteMemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	/**
	 * メンバーを削除する.
	 * @param shioriId　しおりID
	 * @param userId　ユーザーID
	 */
	public void deleteMember(DeleteMemberForm form) {
		MemberExample example=new MemberExample();
		example.createCriteria().andShioriIdEqualTo(form.getShioriId()).andUserIdEqualTo(form.getDeleteUserId());
		memberMapper.deleteByExample(example);
	}
	
}
