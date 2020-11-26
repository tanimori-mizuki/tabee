package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.User;
import com.example.dto.ResetPassword;
import com.example.example.user.UserExample;
import com.example.form.UpdatePasswordForm;
import com.example.mapper.dto.ResetPasswordMapper;
import com.example.mapper.user.UserMapper;

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
	public void registerResetPassword(ResetPassword resetPassword, String email) {
		System.out.println("【ServiceのEmail】:　" + email);
		System.out.println("【Serviceのresetpassword】:　" + resetPassword);
		
		LocalDateTime expireDate = LocalDateTime.now();
		expireDate.plusMinutes(5);
		
		System.out.println("【期限】: " + expireDate);

		UUID uuid = UUID.randomUUID();
		String randomUrl = uuid.toString();
		
		System.out.println("【uuid】: " + uuid);
		System.out.println("【randomURL】" + randomUrl);

		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		
		try {
			List<User> userList = userMapper.selectByExample(example);
			System.out.println("【email一致ユーザー】 : " + userList.get(0));
			User user = userList.get(0);
			
//		if(user == null) {
//			System.out.println("ユーザーいない！");
//			throw new UsernameNotFoundException("入力されたメールアドレスは登録されていません。");
//		}
			
			resetPassword.setUserId(user.getId());
			resetPassword.setRandomUrl(randomUrl);
			resetPassword.setExpireDate(expireDate);
			System.out.println("【resetPassword】 : " + resetPassword);
			
			resetPasswordMapper.insertSelective(resetPassword);
			
		}catch (Exception e) {
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
		System.out.println("メール送信メソッドだよ");
		System.out.println("【sendResetPasswordMailのemail】: " + email);
		System.out.println("【sendResetPasswordMailのresetPassword】: " + resetPassword);
		
		String url = "http://localhost:8888/reset_password" + "?randomUrl=" + resetPassword.getRandomUrl();
		String to = email;
		String subject = "【tabee】パスワード変更はこちら";
		
		StringBuilder text = new StringBuilder();
		text.append("こちらのリンクをクリックしてパスワードを変更してください。\n");
		text.append("※リンクの有効期限：5分\n");
		text.append(url);
		text.append("\n\n\n");
		text.append("こちらのメールに心あたりのない場合は破棄してください。");
		
		System.out.println("【URL】 : " + url);
		System.out.println("【to】 : " + to);
		System.out.println("【subject】 : " + subject);
		
		sendMail(to, subject, text.toString());
		
	}
	
	/**
	 * メール送信メソッド
	 * 
	 * @param to
	 * @param subject
	 * @param text
	 */
	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text);
		System.out.println("【msg】: " + msg);
		
		sender.send(msg);
		
	}

	/**
	 * ユーザーのパスワードを更新.
	 * 
	 * @param user
	 * @return
	 */
	public int UpdatePasswordById(UpdatePasswordForm form, HttpServletRequest req) {
		System.out.println("【フォームのユーザーID】：　" + form.getId());
		System.out.println("【フォームのパスワード】：　" + form.getPassword());
		
		

		User user = new User();
		user.setId(Integer.parseInt(form.getId()));
		user.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));

		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		userMapper.updateByExampleSelective(user, example);

		List<User> newUserList = userMapper.selectByExample(example);
		System.out.println("【更新後パスワード】: " + newUserList.get(0).getPassword());

		return 1;

	}

}
