package com.example.controller.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.memo.DeleteMemoImageService;

@RestController
@RequestMapping("/delete_memoImage")
public class DeleteMemoImageController {
	
	@Autowired
	private DeleteMemoImageService deleteMemoImageService;
	
	/**
	 * メモ画像を削除する.
	 * @param memoImageId メモ画像ID
	 */
	@GetMapping("")
	public void deleteMemoImage(Integer memoImageId) {
		deleteMemoImageService.deleteMemoImage(memoImageId);
	}

}
