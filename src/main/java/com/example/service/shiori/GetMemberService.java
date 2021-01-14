package com.example.service.shiori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.shiori.Member;
import com.example.example.shiori.MemberExample;
import com.example.mapper.shiori.MemberMapper;

/**
 * 指定条件からメンバーの検索を行う.
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetMemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	/**
	 * メンバー情報を取得する.
	 * @param shioriId しおりID
	 * @param userId　ユーザーID
	 * @return
	 */
	public Member getMember(Integer shioriId,Integer userId) {
		MemberExample example=new MemberExample();
		example.createCriteria().andShioriIdEqualTo(shioriId).andUserIdEqualTo(userId);
		List <Member> memberList=memberMapper.selectByExample(example);
		if(memberList.size()!=0) {
			return memberList.get(0);
		}
		return null;
	}

}
