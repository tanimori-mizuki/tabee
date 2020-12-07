package com.example.controller.scrap;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.UploadPathConfiguration;
import com.example.domain.scrap.Image;
import com.example.domain.scrap.Scrap;
import com.example.form.scrap.CreateFolderForm;
import com.example.service.scrap.CreaterFolderService;
import com.example.service.scrap.UploadImageService;

@RestController
@RequestMapping("/scrap")
public class CreateFolderController {
	
	@Autowired
	private CreaterFolderService createFolderService;
	
	@Autowired
	private UploadImageService uploadImageService;
	
	
	/**
	 * 新規フォルダ作成のメソッド.
	 * 
	 * @param form フォルダ名
	 * @return
	 */
	@PostMapping("/create_folder")
	public List<Scrap> createFolder(@RequestBody CreateFolderForm form) {
		return createFolderService.createFolder(form);
	}
	

	/**
	 * ファイルのアップロードを行うメソッド.
	 * 
	 * @param uploadFile Vueから受け取った画像
	 * @return DBに登録されている画像一覧
	 * @throws IOException
	 */
	@PostMapping("/upload_image")
	public List<Image> uploadImage(@RequestParam(value = "file", required = false) MultipartFile uploadFile) throws IOException {
		
		System.out.println("受け取ったファイル：" + uploadFile);
		return uploadImageService.uploadImage(uploadFile);
	
	}

}
