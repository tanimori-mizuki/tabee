package com.example.service.memo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memo.Memo;
import com.example.domain.memo.MemoImage;
import com.example.mapper.memo.MemoMapper;
import com.example.service.shiori.GetShioriByUserIdService;

/**
 * メモ情報を取得するサービス.
 * 
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetMomeListService {

	@Autowired
	private MemoMapper mapper;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;
	
	@Autowired
	private GetShioriByUserIdService getShioriByUserIdService;

	/**
	 * メモリストを取得する.
	 * 
	 * @param shioriId しおりID
	 * @return メモリスト
	 */
	public List<Memo> getMemoList(Integer shioriId) {
		List<Memo> memoList = mapper.selectByshioriId(shioriId);
		if (memoList.size() == 0) {
			return null;
		}
				
		for (Memo memo : memoList) {
			
			//ユーザーが登録した画像がある場合サーバーサイドで処理
			if(memo.getUser().getImagePath()!=null) {
				//ファイルディレクトリは後日確認する
				getShioriByUserIdService.setUserImage(memo.getUser(), memo.getUser().getImagePath(), "shiori/");
			}
			
			List<MemoImage> memoImageList = memo.getMemoImageList();
			//メモ画像の処理
			if (memoImageList.size() != 0) {
				int count = 0;
				for (MemoImage memoImage : memoImageList) {

					String uploadPath = uploadPathConfiguration.getUploadPath() + "memo/" + memoImage.getImagePath();
					try (FileInputStream fis = new FileInputStream(uploadPath);) {
						StringBuffer data = new StringBuffer();
						ByteArrayOutputStream os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						// バイト配列に変換
						while (true) {
							int len = fis.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
						// 画像データをbaseにエンコード
						String base64 = new String(
								org.apache.tomcat.util.codec.binary.Base64.encodeBase64(os.toByteArray()), "ASCII");
						data.append("data:image/jpeg;base64,");
						data.append(base64);

						memoImageList.get(count).setImagePath((data.toString()));
						count++;

					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}

		return memoList;
	}
	

}
