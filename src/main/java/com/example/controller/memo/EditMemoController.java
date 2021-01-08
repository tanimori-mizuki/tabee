package com.example.controller.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.form.memo.EditMemoForm;
import com.example.service.memo.EditMemoService;
import com.example.service.memo.GetMemoService;

/**
 * メモ情報の編集を行うコントローラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/edit_memo")
public class EditMemoController {

	@Autowired
	private GetMemoService getMemoService;
	
	@Autowired
	private EditMemoService editMemoService;
	
	/**
	 * メモ情報の編集を行う.
	 * @param form メモ情報のフォーム.
	 */
	@PostMapping("/do")
	public String editMemo(@RequestPart("OBJ") EditMemoForm form,@RequestParam(value = "file", required = false) List<MultipartFile> uploadFileList )throws Exception {
		//楽観ロック
		Integer version=getMemoService.getMemo(form.getId()).getVersion();
		if(!form.getVersion().equals(version)) {
			return "fail";
		}
		
		//サーバー側でファイルサイズチェック
		if(uploadFileList.size()>4) {
			throw new IllegalArgumentException();
		}
		editMemoService.editMemo(form,uploadFileList);
		return "success";
	}
	
	
}
