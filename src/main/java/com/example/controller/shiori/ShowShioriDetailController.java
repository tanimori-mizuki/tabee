package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.shiori.Shiori;
import com.example.service.shiori.GetShioriService;

@RestController
@RequestMapping("/shiori_detail")
public class ShowShioriDetailController {
	
	@Autowired
	private GetShioriService getShioriService;
	
	/**
	 * しおり情報、目的地情報をする.
	 * 
	 * @param shioriId しおりID
	 * @return　しおり情報
	 */
	@GetMapping("")
	public Shiori showShioriDetail(Integer shioriId) {
		return getShioriService.getShioriDetail(shioriId);
		
	}
	
	/**
	 * 参加者用にしおり詳細情報を獲得する.
	 * @param publicUid 公開しおりID
	 * @return　しおり情報
	 */
	@GetMapping("/join")
	public Shiori showShioriDetailForJoin(String publicUid) {
		System.out.println(publicUid);
		System.out.println(getShioriService.getShioriDetailByPublicUid(publicUid));
		return getShioriService.getShioriDetailByPublicUid(publicUid);
	}

}
