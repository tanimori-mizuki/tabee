package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.form.shiori.RegisterShioriForm;
import com.example.service.shiori.RegisterShioriService;

@RestController
@RequestMapping("/register_shiori")
public class RegisterShioriController {

	@Autowired
	private RegisterShioriService registerShioriService;
	
	/**
	 * @param form フォーム
	 * @param uploadFile 画像データ
	 * @throws Exception
	 */
	@PostMapping("/do")
	public void registerShiori(@RequestPart("OBJ")RegisterShioriForm form,
			@RequestParam(value = "file", required = false) MultipartFile uploadFile)throws Exception{
		System.out.println(form);
		System.out.println(uploadFile);
		registerShioriService.registerShiori(form, uploadFile);
	}
	
}
