package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
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
		LocalDateTime expireDate = LocalDateTime.now();
		expireDate.plusMinutes(5);

		UUID uuid = UUID.randomUUID();
		String randomUrl = uuid.toString();

		User user = findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("入力されたメールアドレスは登録されていません。");
		}

		resetPassword.setUserId(user.getId());
		resetPassword.setRandomUrl(randomUrl);
		resetPassword.setExpireDate(expireDate);
		resetPasswordMapper.insertSelective(resetPassword);
	}
	
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
	 * @param user
	 * @return
	 */
	public int UpdatePasswordById(UpdatePasswordForm form) {
		System.out.println("【フォームのユーザーID】：　" + form.getId());
		System.out.println("【フォームのパスワード】：　" + form.getPassword());
		UserExample example1 = new UserExample();
		example1.createCriteria().andIdEqualTo(Integer.parseInt(form.getId()));
		List<User> userList = userMapper.selectByExample(example1);
		System.out.println("【更新前パスワード】：" + userList.get(0).getPassword());

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
