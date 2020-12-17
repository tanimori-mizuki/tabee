package com.example.controller.shiori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("/getShioriByUserId")
	public List <Shiori> showShioriInfo(Integer userId){
		List<Shiori> shioriList = getShioriByUserIdService.getShioriByUserId(userId);
		return shioriList;
		
	}
	
	

}
