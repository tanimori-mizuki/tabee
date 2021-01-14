package com.example.controller.shiori;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.shiori.Member;
import com.example.form.shiori.RegisterMemberForm;
import com.example.service.shiori.GetMemberService;
import com.example.service.shiori.RegisterMemberService;

/**
 * しおりのメンバーを登録する.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/join_shiori")
public class RegisterMemberController {
	
	@Autowired
	private RegisterMemberService registerMemberService;
	
	@Autowired
	private GetMemberService getMemberService;
	
	/**
	 * メンバーの登録を行う.
	 * @param shioriId しおりID
	 * @param loginUserId　ログインユーザーID
	 */
	@PostMapping("/do")
	public String registerMember(@RequestBody RegisterMemberForm form) {
		//登録済みの情報かチェックする
		Member member=getMemberService.getMember(form.getShioriId(),form.getLoginUserId());
		if(Objects.nonNull(member)) {
			return "fail";
		}
		registerMemberService.registerMember(form);
		return "success";
	}

}
