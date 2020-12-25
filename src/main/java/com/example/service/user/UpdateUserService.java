package com.example.service.user;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


import com.example.common.UploadPathConfiguration;
import com.example.form.user.UpdateUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.ResetPassword;
import com.example.domain.user.User;
import com.example.example.user.UserExample;
import com.example.form.user.UpdateEmailForm;
import com.example.form.user.UpdatePasswordForm;
import com.example.mapper.user.ResetPasswordMapper;
import com.example.mapper.user.UserMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

/**
 * ユーザー情報更新系のサービス
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class UpdateUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ResetPasswordMapper resetPasswordMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private MailSender sender;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;

	/**
	 * メールアドレスで1件検索.
	 * 
	 * @param email メールアドレス
	 * @return
	 */
	public User findByEmail(String email) {
		return userMapper.findByEmail(email);
	}

	/**
	 * ユーザーID、URL、有効期限を保存.
	 * 
	 * @param req
	 * @param resetPassword
	 * @param email
	 */
	public User registerResetPassword(ResetPassword resetPassword, String email) {

		LocalDateTime expireDate = LocalDateTime.now();
		expireDate = expireDate.plusMinutes(5);

		UUID uuid = UUID.randomUUID();
		String randomUrl = uuid.toString();

		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);

		try {

			List<User> userList = userMapper.selectByExample(example);
			User user = userList.get(0);

			resetPassword.setUserId(user.getId());
			resetPassword.setRandomUrl(randomUrl);
			resetPassword.setExpireDate(expireDate);

			resetPasswordMapper.insertSelective(resetPassword);
			return user;

		} catch (Exception e) {
			throw new UsernameNotFoundException("そのメールアドレスは登録されていません。");
		}

	}

	/**
	 * メール内容セット + 送信
	 * 
	 * @param resetPassword
	 * @param email
	 */
	public void sendResetPasswordMail(ResetPassword resetPassword, String email) {

		String url = "http://localhost:8888/reset_password" + "?randomUrl=" + resetPassword.getRandomUrl();
		String to = email;
		String subject = "【tabee】パスワード変更はこちら";

		StringBuilder text = new StringBuilder();
		text.append("こちらのリンクをクリックしてパスワードを変更してください。\n");
		text.append("※リンクの有効期限：5分\n");
		text.append(url);
		text.append("\n\n\n");
		text.append("こちらのメールに心あたりのない場合は破棄してください。");

		sendMail(to, subject, text.toString());

	}

	/**
	 * メール送信メソッド
	 * 
	 * @param to      宛先
	 * @param subject 表題
	 * @param text    内容
	 */
	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text);

		sender.send(msg);

	}

	/**
	 * ユーザーのパスワードを更新.
	 * 
	 * @param form
	 * @return
	 */
	public int UpdatePassword(UpdatePasswordForm form) {

		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdEqualTo(Integer.parseInt(form.getUserId()));
		User user = userMapper.selectByExample(userExample).get(0);

		user.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));
		user.setUpdatedAt(LocalDateTime.now());

		return userMapper.updateByExampleSelective(user, userExample);
	}

	/**
	 * メールアドレスを更新.
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public User UpdateEmail(UpdateEmailForm form) throws Exception {
		//入力されたメールアドレスの重複検証
		UserExample emailExample = new UserExample();
		emailExample.createCriteria().andEmailEqualTo(form.getEmail());
		
		List<User> userListByEmail = userMapper.selectByExample(emailExample);
			
		if(userListByEmail.size() != 0) {
			throw new Exception("そのメールアドレスはすでに登録されています。");
		}

		//フォームで入力された情報をオブジェクトにセット
		//メールアドレス更新
		User user = new User();
		user.setId(Integer.parseInt(form.getUserId()));
		user.setEmail(form.getEmail());
		user.setUpdatedAt(LocalDateTime.now());
		
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		
		userMapper.updateByExampleSelective(user, example);

		//更新されたメールアドレスが入ったユーザー情報をリターン
		UserExample newEmailExample = new UserExample();
		emailExample.createCriteria().andEmailEqualTo(form.getEmail());

		try {
			List<User> userList = userMapper.selectByExample(newEmailExample);
			return userList.get(0);

		} catch (Exception e) {
			throw new UsernameNotFoundException("入力されたメールアドレスでの更新処理が正常に処理できませんでした。");
		}
	}

	/**
	 * ユーザー名とアイコン画像を更新するメソッド.
	 *
	 * @param form 更新ユーザーフォーム
	 * @return　
	 * @throws Exception
	 */
	public User updateProfile(UpdateUserForm form, MultipartFile uploadFile) throws Exception {

		User user = new User();
		user.setId(Integer.parseInt(form.getId()));
		user.setName(form.getName());

		user.setUpdatedAt(LocalDateTime.now());

		if (uploadFile != null) {
			String fileExtension = getExtension(uploadFile.getOriginalFilename());
			if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
				System.err.println("拡張子エラー");
				throw new IllegalArgumentException();
			}

			try {
				// 保存先を定義
				String uploadPath = uploadPathConfiguration.getUploadPath() + "userIcon/";
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
				user.setImagePath(imagePath);

			} catch (Exception e) {
				System.out.println("例外発生：" + e.getMessage());
			}
		}
		userMapper.updateByPrimaryKeySelective(user);

		return user;
	}

	/**
	 * ファイル名から拡張子を返すメソッド.
	 *
	 * @param originalFileName ファイル名
	 * @return .を除いたファイルの拡張子
	 * @throws Exception
	 */
	private String getExtension(String originalFileName) throws Exception {
		if (originalFileName == null) {
			throw new FileNotFoundException();
		}
		int point = originalFileName.lastIndexOf(".");
		if (point == -1) {
			throw new FileNotFoundException();
		}
		return originalFileName.substring(point + 1);
	}


	/**
	 * ユーザーアカウントを削除するメソッド.
	 *
	 * @param form
	 */
	public void deleteUser(UpdateUserForm form){

		User user = new User();
		user.setId(Integer.parseInt(form.getId()));
		user.setUpdatedAt(LocalDateTime.now());
		user.setDeleted(1);
		userMapper.updateByPrimaryKeySelective(user);
	}

}
