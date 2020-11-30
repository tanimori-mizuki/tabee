package com.example.controller.scrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.scrap.Scrap;
import com.example.form.scrap.CreateFolderForm;
import com.example.service.scrap.CreaterFolderService;

@RestController
@RequestMapping("/scrap")
public class CreateFolderController {
	
	@Autowired
	private CreaterFolderService createFolderService;
	
	@PostMapping("/create_folder")
	public List<Scrap> createFolder(@RequestBody CreateFolderForm form) {
		return createFolderService.createFolder(form);
	}

}
