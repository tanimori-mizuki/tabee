package com.example.controller.shiori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.LoginUser;
import com.example.domain.shiori.Shiori;
import com.example.service.shiori.GetShioriByUserIdService;

/**
 * しおり情報を取得するコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/shiori")
public class ShowShioriListController {
	
	@Autowired
	private GetShioriByUserIdService getShioriByUserIdService;
	
	/**
	 * しおり情報を取得する.
	 * @param loginUser ログイン者情報
	 * @return　しおり情報
	 */
	@GetMapping("")
	public List <Shiori> showShioriList(@AuthenticationPrincipal LoginUser loginUser){
		
//		Integer userId=loginUser.getUser().getId();
		System.out.println(getShioriByUserIdService.getShioriByUserId(1));
		return getShioriByUserIdService.getShioriByUserId(1);
		
	}
	
	/**
	 * しおり情報を取得する.
	 * @param loginUser ログイン者情報
	 * @return　しおり情報
	 */
	@GetMapping("/getShioriByUserId")
	public List <Shiori> showShioriInfo(Integer id){
		System.out.println("【id】 " + id);
		
		System.out.println("【IDで取得したしおり情報】 " + getShioriByUserIdService.getShioriByUserId(id));
		List<Shiori> shioriList = getShioriByUserIdService.getShioriByUserId(id);
		System.out.println("shioriList: " + shioriList);
		return shioriList;
		
	}
	
	

}
