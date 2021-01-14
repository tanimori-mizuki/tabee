
package com.example.service.shiori;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.UploadPathConfiguration;
import com.example.domain.shiori.Shiori;
import com.example.domain.user.User;
import com.example.mapper.shiori.ShioriMapper;

/**
 * しおり情報を取得する.
 * 
 * @author yuri.okada
 *
 */
@Service
@Transactional
public class GetShioriService {

	@Autowired
	private ShioriMapper shioriMapper;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;

	/**
	 * 主キーからしおり情報を取得する.
	 * 
	 * @param shioriId しおりID
	 * @return しおり情報
	 */
	public Shiori getShioriByShioriId(Integer shioriId) {
		return shioriMapper.selectByPrimaryKey(shioriId);
	}

	/**
	 * しおりIDからしおり情報、目的地情報を取得する.
	 * 
	 * @param shioriId しおりID
	 * @return しおり情報
	 */
	public Shiori getShioriDetail(Integer shioriId) {
		Shiori shiori = shioriMapper.selectByShioriId(shioriId);
		shiori = getShiori(shiori);
		return shiori;
	}

	/**
	 * publicUidからしおり情報を取得する.
	 * 
	 * @param publicUid 公開しおりID
	 * @return しおり情報
	 */
	public Shiori getShioriDetailByPublicUid(String publicUid) {
		Shiori shiori=shioriMapper.selectByPublicUid(publicUid);
		shiori = getShiori(shiori);		
		return shiori;
	}

	/**
	 * しおり情報の取得、画像の変換処理を行う.
	 * 
	 * @param shiori しおり
	 * @return 変換したしおり情報
	 */
	private Shiori getShiori(Shiori shiori) {

		for (User user : shiori.getUserList()) {
			if (user.getImagePath() != null) {
				// ファイルディレクトリは後日確認する
				setUserImage(user, user.getImagePath(), "shiori/");
			}
		}
		if (shiori.getImagePath() != null) {
			String uploadPath = uploadPathConfiguration.getUploadPath() + "shiori/" + shiori.getImagePath();
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
				String base64 = new String(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(os.toByteArray()),
						"ASCII");
				data.append("data:image/jpeg;base64,");
				data.append(base64);

				shiori.setImagePath(data.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return shiori;

	}

	/**
	 * サーバーサイドに保存されたユーザー画像情報をバイナリに変換する.
	 * 
	 * @param imagePath
	 * @param fileDirectory
	 */
	private void setUserImage(User user, String imagePath, String fileDirectory) {
		String uploadPath = uploadPathConfiguration.getUploadPath() + fileDirectory + imagePath;
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
			String base64 = new String(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(os.toByteArray()),
					"ASCII");
			data.append("data:image/jpeg;base64,");
			data.append(base64);

			user.setImagePath(data.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
