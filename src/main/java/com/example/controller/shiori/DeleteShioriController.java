package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.shiori.DeleteShioriService;

/**
 * しおりの削除を行うコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/delete_shiori")
public class DeleteShioriController {
	
	@Autowired
	private DeleteShioriService deleteShioriService;
	
	/**
	 * しおりを削除する.
	 * @param shioriId
	 */
	@GetMapping("")
	public void deleteShiori(Integer shioriId) {
		deleteShioriService.deleteShiori(shioriId);
		
	}

}
