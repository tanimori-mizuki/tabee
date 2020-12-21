package com.example.service.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.User;
import com.example.example.user.UserExample;
import com.example.form.user.RegisterUserForm;
import com.example.mapper.user.UserMapper;


/**
 * ユーザー登録を行うサービスクラス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class RegisterUserSevice {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MailSender sender;

	/**
	 * ユーザー登録を行います.
	 * 
	 * @param form フォーム
	 * @return 登録ユーザー情報
	 * @throws Exception 
	 */
	public User registerUser(RegisterUserForm form) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(form.getEmail());
		
		List<User> userListByEmail = userMapper.selectByExample(example);
		
		if(userListByEmail.size() != 0) {
			throw new Exception("すでに登録済み");
		
		}else {
		
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		String encodedPassword = passwordEncoder.encode(form.getPassword());
		user.setPassword(encodedPassword);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		
		userMapper.insert(user);
		
		User newUser = userMapper.findByEmail(form.getEmail());
		
		sendRegisterCompleteMail(form);
		
		return newUser;
		
		}
	}
	
	/**
	 * メール内容セット + 送信
	 * 
	 * @param resetPassword
	 * @param email
	 */
	public void sendRegisterCompleteMail(RegisterUserForm form) {
		
		String to = form.getEmail();
		String subject = "【tabee】ユーザー登録完了";
		
		StringBuilder text = new StringBuilder();
		text.append("この度はtabeeにご登録いただきありがとうございます。\n\n");
		text.append("【ご登録いただいたユーザー情報】\n");
		text.append("ユーザー名： " + form.getName() + "\n");
		text.append("メールアドレス： " + form.getEmail() + "\n");
		
		int pwdLen = form.getPassword().length();
		StringBuilder hiddenPassword = new StringBuilder(pwdLen);
		for (int i = 0; i < pwdLen; i++) {
			hiddenPassword.append("*");
		}
		
		text.append("パスワード： " + hiddenPassword + "\n");
		
		text.append("\n");
		text.append("※こちらのメールに心あたりのない場合は破棄してください。");
		
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
		
		sender.send(msg);
		
	}
}

