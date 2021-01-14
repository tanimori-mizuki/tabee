package com.example.service.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.shiori.Member;
import com.example.form.shiori.RegisterMemberForm;
import com.example.mapper.shiori.MemberMapper;

/**
 * しおりのメンバー情報を登録するサービス.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class RegisterMemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	/**
	 * メンバーを登録する.
	 * @param shioriId しおりID
	 * @param loginUserId　ログインユーザID
	 */
	public void registerMember(RegisterMemberForm form) {
		Member member=new Member();
		member.setShioriId(form.getShioriId());
		member.setUserId(form.getLoginUserId());
		memberMapper.insertSelective(member);
	}

}
