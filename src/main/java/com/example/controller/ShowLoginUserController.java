package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.ShowLoginInfoService;

/**
 * ログインユーザー情報を返すコントローラ.
 * 
 * @author masashi.nose
 *
 */
@RestController
@RequestMapping("/user")
public class ShowLoginUserController {

	@Autowired
	private ShowLoginInfoService showLoginInfoService;

	/**
	 * ログインユーザー情報を渡す.
	 * 
	 * @param params
	 * @return
	 */
	@GetMapping("/showLoginUser")
	public User getLoginUser(@RequestParam Map<String, String> params) {
		return showLoginInfoService.showLoginUser(params.get("email"));

	}
}
