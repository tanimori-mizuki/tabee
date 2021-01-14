package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.form.shiori.EditShioriForm;
import com.example.service.shiori.EditShioriService;
import com.example.service.shiori.GetShioriService;

@RestController
@RequestMapping("/edit_shiori")
public class EdtiShioriController {

	@Autowired
	private EditShioriService editShioriService;
	
	@Autowired
	private GetShioriService getShioriService;
	
	/**
	 * しおり情報を編集する.
	 * @param form 編集フォーム
	 * @param uploadFileList　画像情報
	 * @return　処理結果
	 * @throws Exception
	 */
	@PostMapping("/do")
	public String editShiori(@RequestPart("OBJ") EditShioriForm form,@RequestParam(value = "file", required = false) MultipartFile uploadFile )throws Exception{
		//楽観ロック
		Integer version=getShioriService.getShioriByShioriId(form.getId()).getVersion();
		if(!form.getVersion().equals(version)) {
			return "fail";
		}
		editShioriService.editShiori(form, uploadFile);
		return "success";
	}
	
}
