package com.example.service.memory;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memory.Memory;
import com.example.domain.memory.MemoryImage;
import com.example.domain.memory.ScheForPost;
import com.example.form.memory.RegisterMemoryForm;
import com.example.mapper.memory.MemoryImageMapper;
import com.example.mapper.memory.MemoryMapper;
import com.example.mapper.memory.ScheForPostMapper;

/**
 * 思い出を登録するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterMemoryService {

	@Autowired
	private ScheForPostMapper scheForPostMapper;

	@Autowired
	private MemoryMapper memoryMapper;

	@Autowired
	private MemoryImageMapper memoryImageMapper;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;

	/**
	 * 思い出を投稿.
	 * 
	 * @param memory 思い出情報.
	 */
	public void registerMemory(RegisterMemoryForm form, List<MultipartFile> uploadFileList) throws Exception {
		System.out.println(form);
		System.out.println(uploadFileList);

		Memory memory = new Memory();
		memory.setTitle(form.getTitle());
		memory.setContent(form.getContent());
		memory.setUserId(Integer.parseInt(form.getUserId()));
		memory.setPostAt(LocalDateTime.now());
		
		if(ObjectUtils.isEmpty(form.getIsPublicSche())) {
			memory.setPublicSche(false);
		}else {
			memory.setPublicSche(form.getIsPublicSche());
		}
		memory.setShioriId(Integer.parseInt(form.getShioriId()));

		memoryMapper.insertSelective(memory);
		
		List<MemoryImage> memoryImageList = new ArrayList<>();
		Iterator<ImageWriter> writers = null;

		if (uploadFileList != null) {
			String fileExtention = null;
			for (MultipartFile uploadFile : uploadFileList) {
				fileExtention = getExtension(uploadFile.getOriginalFilename());
				
				if (!"jpg".equals(fileExtention) && !"png".equals(fileExtention)) {
					throw new IllegalArgumentException();
				}
			}
			try {
				for (MultipartFile uploadFile : uploadFileList) {
					// 保存先を定義
					String uploadPath = uploadPathConfiguration.getUploadPath() + "memory/";
					byte[] bytes = uploadFile.getBytes();

					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(uploadPath + new File(uploadFile.getOriginalFilename()))));
					stream.write(bytes);
					stream.close();

					// 圧縮
					File input = new File(uploadPath + new File(uploadFile.getOriginalFilename()));
					BufferedImage image = ImageIO.read(input);
					OutputStream os = new FileOutputStream(input);
					
					// 拡張子に応じて処理
					if ("jpg".equals(fileExtention)) {
						writers = ImageIO.getImageWritersByFormatName("jpg");

					} else {
						writers = ImageIO.getImageWritersByFormatName("png");
					}

					ImageWriter writer = writers.next();
					
					ImageOutputStream ios = ImageIO.createImageOutputStream(os);
					writer.setOutput(ios);
					ImageWriteParam param = new JPEGImageWriteParam(null);
					param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					param.setCompressionQuality(0.30f);
					writer.write(null, new IIOImage(image, null, null), param);
					os.close();
					ios.close();
					writer.dispose();

					File fileName = new File(uploadFile.getOriginalFilename());
					String imagePath = fileName.toString();
					
					MemoryImage memoryImage = new MemoryImage();
					memoryImage.setMemoryId(memory.getId());
					memoryImage.setImagePath(imagePath);
					memoryImageList.add(memoryImage);

				}
				
				memoryImageMapper.insertMemoryImageList(memoryImageList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 
	 * ファイル名から拡張子を返す.
	 * 
	 * @param originalFileName ファイル名
	 * @return .を除いたファイルの拡張子
	 * @throws Exception
	 */
	private String getExtension(String originalFileName) throws Exception {
		if (originalFileName == null) {
			throw new FileNotFoundException();
		}

		// lastIndexOfは、指定された値が最後に現れるインデックス(文字の位置)を返す(インデックスの長さ-1、0がスタートのため)。
		// 見つからなかった場合は -1 。
		int point = originalFileName.lastIndexOf(".");
		if (point == -1) {
			throw new FileNotFoundException();
		}

		// .がある位置の後の文字列（拡張子）を返す.
		return originalFileName.substring(point + 1);

	}

}
