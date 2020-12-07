package com.example.service.scrap;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.common.UploadPathConfiguration;
import com.example.domain.scrap.Image;
import com.example.mapper.scrap.ImageMapper;

/**
 * スクラップフォルダーのファイルアップロードサービス.
 * 
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class UploadImageService {
	
	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;
	
	@Autowired
	private ImageMapper imageMapper;
	
	/**
	 * 画像をDBとフォルダにインサートするメソッド.
	 * 
	 * @param uploadFile
	 * @return
	 * @throws IOException
	 */
	public List<Image> uploadImage(MultipartFile uploadFile) throws IOException {
		
		Image img = new Image();
		
		// 画像チェック
		if(uploadFile != null) {
			
			try {
				
				// 保存先を定義(ymlに記載)
				String uploadPath = uploadPathConfiguration.getUploadPath() + "scrap/";
				System.out.println("--------①uploadPath--------");
				System.out.println(uploadPath);
				// 画像のデータ容量
				byte[] bytes = uploadFile.getBytes();
				System.out.println("--------②bytes--------");
				System.out.println(bytes);
				
				// 指定ファイルへ読み込みファイルを書き込み
				// データをバイナリに変換
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(uploadPath + new File(uploadFile.getOriginalFilename()))));
				stream.write(bytes);
				stream.close();
				System.out.println("--------③ファイル書き込みstream--------");
				System.out.println(stream);
				
				// --------------圧縮----------------------
				// 保存先+ファイル名
				File input = new File(uploadPath + new File(uploadFile.getOriginalFilename()));
				System.out.println("--------④input--------");
				System.out.println(input);
				// 画像ファイルから読み込んだデータをデコードしてBufferedImageクラスのオブジェクトとして読み込む
				// BufferedImageクラスは画像を構成するピクセル情報等を保持
				BufferedImage image = ImageIO.read(input);
				System.out.println("--------⑤BufferedImage--------");
				System.out.println(image);
				// 出力ファイルを開く(inputは書き込むファイルのパス)
				OutputStream os = new FileOutputStream(input);
				System.out.println("--------⑥OutputStream--------");
				System.out.println(os);
				// ファイル形式の指定
				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
				System.out.println("--------⑦Iterator<ImageWriter>--------");
				System.out.println(writers);
				ImageWriter writer = writers.next();
				System.out.println("--------⑧ImageWriter--------");
				System.out.println(writer);
				// 指定された Object に出力を送信する
				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				System.out.println("--------⑨ImageOutputStream--------");
				System.out.println(ios);
				writer.setOutput(ios);
				// JPEGImageWriteParamの構成(下記品質以外はデフォルト/JPEGと呼ばれる一つの圧縮形式がサポートされる)
				ImageWriteParam param = new JPEGImageWriteParam(null);
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);		// 今後の書き込み機能を使用可能にする
				param.setCompressionQuality(0.30f);												// 	圧縮の品質を設定
				System.out.println("--------⑩ImageWriteParam--------");
				System.out.println(param);
				// 1 つのイメージ、関連付けられたストリームとイメージメタデータ、およびサムネールを含む完全なイメージストリームを出力に追加
				writer.write(null, new IIOImage(image, null, null), param);
				// 出力ファイルを閉じる
				os.close();
				// ストリームを閉じる
				ios.close();
				writer.dispose();
				System.out.println("--------⑪os2--------");
				System.out.println(os);
				System.out.println("--------⑫ios2--------");
				System.out.println(ios);
				System.out.println("--------⑬writer2--------");
				System.out.println(writer);
				
				// DBにinsert
				File fileName = new File(uploadFile.getOriginalFilename());
				System.out.println("----ファイル名-----");
				System.out.println(fileName);
				String imagePath = fileName.toString();
				System.out.println("----イメージパス-----");
				System.out.println(imagePath);
				String personalId = fileName.toString().substring(0, 4);
				System.out.println("----personalId-----");
				System.out.println(personalId);
				
				img.setScrapId(17);
				img.setImagePath(imagePath);
				img.setCreatorId(7);
				img.setCreatedAt(new Date());
				
				imageMapper.insertSelective(img);
				
			} catch (Exception e) {
				System.out.println("例外発生：" + e.getMessage());
			}
			
		}
		
		// 返す一覧データ
		List<Image>imageList = imageMapper.findAll();
		System.out.println(imageList);
		
		return imageList;
		
//		String fileExtension = null;
//		
//		try {
//			
//			fileExtension = getExtension(uploadFile.getOriginalFilename());
//			System.out.println("-----②fileExtension-----");
//			System.out.println(fileExtension);
//			
//			if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
//				System.out.println("拡張子は.jpgか.pngのみに対応しています");
//			}
//		} catch (Exception e) {
//			System.out.println("拡張子は.jpgか.pngのみに対応しています");
//			System.out.println("例外発生" + e.getMessage());
//		}
//		
//		// 画像ファイルをBase64形式にエンコード
//		String base64FileString = Base64.getEncoder().encodeToString(uploadFile.getBytes());
//		System.out.println("-----画像ファイルエンコード-----");
//		System.out.println(base64FileString);
//		if ("jpg".equals(fileExtension)) {
//			base64FileString = "data:image/jpeg;base64," + base64FileString;
//			System.out.println("-----エンコード①-----");
//			System.out.println(base64FileString);
//		} else if ("png".equals(fileExtension)) {
//			base64FileString = "data:image/png;base64," + base64FileString;
//			System.out.println("-----エンコード②-----");
//			System.out.println(base64FileString);
//		}
//		
//		img.setScrapId(17);
//		img.setImagePath(base64FileString);
//		img.setCreatorId(7);
//		img.setCreatedAt(new Date());
//		
//		imageMapper.insertSelective(img);
	}
	
	/*
	 * ファイル名から拡張子を返します.
	 * 
	 * @param originalFileName ファイル名
	 * 
	 * @return .を除いたファイルの拡張子
	 */
//	private String getExtension(String originalFileName) throws Exception {
//		if (originalFileName == null) {
//			throw new FileNotFoundException();
//		}
//		int point = originalFileName.lastIndexOf(".");
//		if (point == -1) {
//			throw new FileNotFoundException();
//		}
//		System.out.println("----返す値----");
//		System.out.println(originalFileName.substring(point + 1));
//		return originalFileName.substring(point + 1);
//	}

}
