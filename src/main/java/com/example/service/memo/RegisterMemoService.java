package com.example.service.memo;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memo.Memo;
import com.example.domain.memo.MemoImage;
import com.example.form.RegisterMemoForm;
import com.example.mapper.memo.MemoImageMapper;
import com.example.mapper.memo.MemoMapper;

/**
 * メモ情報を登録するサービス.
 * 
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class RegisterMemoService {

	@Autowired
	private MemoMapper memoMapper;
	
	@Autowired
	private MemoImageMapper memoImageMapper;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;

	/**
	 * メモ情報を登録する.
	 * 
	 * @return 成功件数
	 */
	public void registerMemo(RegisterMemoForm form, List<MultipartFile> uploadFileList) {

		Memo memo = new Memo();
		BeanUtils.copyProperties(form, memo);
		memo.setCreatedAt(LocalDateTime.now());
		memo.setUpdaterId(form.getCreatorId());
		memo.setUpdatedAt(LocalDateTime.now());
		memo.setVersion(1);
		memoMapper.insertSelective(memo);

		// 画像チェック
		if (uploadFileList != null) {
			List <MemoImage> memoImageList=new ArrayList<>();
			try {
				for(MultipartFile uploadFile:uploadFileList) {

				// 保存先を定義
				String uploadPath = uploadPathConfiguration.getUploadPath() + "memo/";
				byte[] bytes = uploadFile.getBytes();

				// 指定ファイルへ読み込みファイルを書き込み
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(uploadPath + new File(uploadFile.getOriginalFilename()))));
				stream.write(bytes);
				stream.close();

				// 圧縮
				File input = new File(uploadPath + new File(uploadFile.getOriginalFilename()));
				BufferedImage image = ImageIO.read(input);
				OutputStream os = new FileOutputStream(input);
				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
				ImageWriter writer = writers.next();
				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				writer.setOutput(ios);
				// jpegのみ可能?
				ImageWriteParam param = new JPEGImageWriteParam(null);
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(0.30f);
				writer.write(null, new IIOImage(image, null, null), param);
				os.close();
				ios.close();
				writer.dispose();

				File fileName = new File(uploadFile.getOriginalFilename());
				String imagePath = fileName.toString();
				MemoImage memoImage=new MemoImage();
				
				memoImage.setMemoId(memo.getId());
				memoImage.setImagePath(imagePath);
				memoImage.setCreatorId(form.getCreatorId());
				memoImage.setCreatedAt(LocalDateTime.now());
				memoImageList.add(memoImage);
				
				}
				
				memoImageMapper.insertMemoImageList(memoImageList);
			} catch (Exception e) {
				System.out.println("例外発生：" + e.getMessage());
			}
		}

		System.out.println("serviceのmemo" + memo);

	}
}