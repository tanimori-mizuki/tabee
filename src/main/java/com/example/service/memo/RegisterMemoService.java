package com.example.service.memo;

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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memo.Memo;
import com.example.domain.memo.MemoImage;
import com.example.form.memo.RegisterMemoForm;
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
	public void registerMemo(RegisterMemoForm form, List<MultipartFile> uploadFileList) throws Exception {
		
			Memo memo = new Memo();
			BeanUtils.copyProperties(form, memo);
			memo.setCreatedAt(LocalDateTime.now());
			memo.setUpdaterId(form.getCreatorId());
			memo.setUpdatedAt(LocalDateTime.now());
			memo.setVersion(1);
			memoMapper.insertSelective(memo);

			List<MemoImage> memoImageList = new ArrayList<>();
			Iterator<ImageWriter> writers = null;
			// 画像の拡張子チェック
			if (uploadFileList != null) {
				String fileExtension = null;
				for (MultipartFile uploadFile : uploadFileList) {
					// jpg,png以外のファイル形式が指定された場合に例外発生
					fileExtension = getExtension(uploadFile.getOriginalFilename());
					if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
						System.err.println("拡張子エラー");
						throw new IllegalArgumentException();
					}
				}
			try {
				for (MultipartFile uploadFile : uploadFileList) {

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
					// 拡張子に応じて処理
					if ("jpg".equals(fileExtension)) {
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

					// 画像情報をmemoImageListに格納
					File fileName = new File(uploadFile.getOriginalFilename());
					String imagePath = fileName.toString();
					MemoImage memoImage = new MemoImage();
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
	}

	/*
	 * ファイル名から拡張子を返す.
	 * 
	 * @param originalFileName ファイル名
	 * 
	 * @return .を除いたファイルの拡張子
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
		// .がある位置の後の文字列(拡張子)を返す
		return originalFileName.substring(point + 1);
	}
}