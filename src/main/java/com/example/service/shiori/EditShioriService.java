package com.example.service.shiori;

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
import com.example.domain.shiori.Destination;
import com.example.domain.shiori.Shiori;
import com.example.form.shiori.EditShioriForm;
import com.example.mapper.shiori.DestinationMapper;
import com.example.mapper.shiori.ShioriMapper;

/**
 * しおりの編集を行うサービス.
 * @author yuri.okada
 *
 */
@Transactional
@Service
public class EditShioriService {
	
	@Autowired
	private ShioriMapper shioriMapper;
	
	@Autowired
	private DestinationMapper destinationMapper;
	
	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;
	
	/**
	 * しおりを編集する.
	 * @param form　しおりの編集情報.
	 * @param uploadFile 画像ファイル情報
	 * @throws Exception
	 */
	public void editShiori(EditShioriForm form,MultipartFile uploadFile) throws Exception {
		
		Shiori shiori = new Shiori();
		BeanUtils.copyProperties(form, shiori);
		shiori.setCreatedAt(LocalDateTime.now());
		shiori.setUpdatedAt(LocalDateTime.now());
		shiori.setUpdaterId(form.getCreatorId());
		shiori.setVersion(form.getVersion()+1);

		if (uploadFile != null) {
			String fileExtension = getExtension(uploadFile.getOriginalFilename());
			if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
				System.err.println("拡張子エラー");
				throw new IllegalArgumentException();
			}

			try {
				// 保存先を定義
				String uploadPath = uploadPathConfiguration.getUploadPath() + "shiori/";
				byte[] bytes = uploadFile.getBytes();
				Iterator<ImageWriter> writers = null;

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

				File fileName = new File(uploadFile.getOriginalFilename());
				String imagePath = fileName.toString();
				shiori.setImagePath(imagePath);

			} catch (Exception e) {
				System.out.println("例外発生：" + e.getMessage());
			}
		}

		//更新をする
		shioriMapper.updateByPrimaryKeySelective(shiori);
		
		//DBに登録されている目的地情報
		List <Destination> registeredDestinationList=form.getRegisterdDestinationList();
		int registeredDestinationCount=registeredDestinationList.size();
		List <Integer> destinationIdList=form.getDestinationIdList();
	
		
		List<String> destinationNameList = form.getDestinationList();
		//セレクトボックスが未選択の時nullとなるため、nullを全て削除
		if (destinationNameList.contains(null)) {
			while (destinationNameList.remove(null));
		}
		//上記同様、未定の時も削除
		if(destinationNameList.contains("未定")) {
			while(destinationNameList.remove("未定"));
		}
		int inputDestinationCount=destinationNameList.size();
		
		//入力値が存在する時
		if(inputDestinationCount>0) {
			List <Destination> destinationList=new ArrayList<>();
			for (String destinationName : destinationNameList) {
				Destination destination = new Destination();
				destination.setShioriId(shiori.getId());
				destination.setDestination(destinationName);
				destinationList.add(destination);
			}
		//目的地のDB登録数、入力数に応じて条件分岐
		if (registeredDestinationCount==0) {
			System.err.println("登録情報なし");
			destinationMapper.insertDestinationList(destinationList);
		}else if(registeredDestinationCount==inputDestinationCount) {
			System.err.println("数一致");
			destinationMapper.updateDestinations(destinationList, form.getDestinationIdList());
		}else if(registeredDestinationCount>inputDestinationCount) {
			System.err.println("登録数＞入力");
			//差分を削除、入力分を更新
				List <Integer> updateIdList=destinationIdList.subList(0,inputDestinationCount);
				List <Integer> deleteIdList=destinationIdList.subList(inputDestinationCount, registeredDestinationCount);
				destinationMapper.updateDestinations(destinationList,updateIdList);
				destinationMapper.deleteDetinations(deleteIdList);
		}else if(registeredDestinationCount<inputDestinationCount) {
			System.err.println("登録数<入力");
			//差分をインサート、入力分を更新
			List <Destination> updateDestinationList=destinationList.subList(0, registeredDestinationCount);
			List <Destination> insertDestinationList=destinationList.subList(registeredDestinationCount,inputDestinationCount);
			destinationMapper.updateDestinations(updateDestinationList,destinationIdList);
			destinationMapper.insertDestinationList(insertDestinationList);
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
