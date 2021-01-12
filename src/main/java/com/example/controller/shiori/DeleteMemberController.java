package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.shiori.DeleteMemberForm;
import com.example.service.shiori.DeleteMemberService;

@RestController
@RequestMapping("/delete_member")
public class DeleteMemberController {
	
	@Autowired
	private DeleteMemberService deleteMemberService;
	
	
	/**
	 * メンバーの削除を行う.
	 * @param shioriId しおりID
	 * @param userId　ユーザーID
	 */
	@GetMapping("")
	public String deleteMember(DeleteMemberForm form) {
		if(form.getCreatorId().equals(form.getDeleteUserId())) {
			return "fail";
		}
		deleteMemberService.deleteMember(form);
		return "success";
	}

}
