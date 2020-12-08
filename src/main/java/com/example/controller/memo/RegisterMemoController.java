package com.example.controller.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.form.RegisterMemoForm;
import com.example.service.memo.RegisterMemoService;

/**
 * メモ登録処理を行うコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/register_memo")
public class RegisterMemoController {

	@Autowired
	private RegisterMemoService registerMemoService;
	
	/**
	 * メモ情報を登録する.
	 * @param form
	 */
	@PostMapping("/do")
	public void registerMemo(@RequestPart("OBJ") RegisterMemoForm form,@RequestParam(value = "file", required = false) List<MultipartFile> uploadFileList )throws Exception{
		registerMemoService.registerMemo(form,uploadFileList);
	}
	
	
}
