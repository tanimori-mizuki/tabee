package com.example.domain.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * ログイン情報を表すドメイン.
 * 
 * @author yuri.okadad
 *
 */
@SuppressWarnings("serial")
public class LoginUser extends org.springframework.security.core.userdetails.User {

	/** ログイン情報 */
	private final User user;

	/**
	 * 通常の管理者情報に加え、認可用ロールを設定する.
	 * 
	 * @param user          ユーザー情報
	 * @param authorityList 権限リスト
	 */
	public LoginUser(User user, Collection<GrantedAuthority> authorityList) {
		// スーパークラスのユーザーID、パスワードに値をセットする
		// 実際の認証はスーパークラスのユーザーID、パスワードで行われる
		super(user.getEmail(), user.getPassword(), authorityList);
		this.user = user;
	}

	/**
	 * ログイン情報を取得する.
	 * 
	 * @return ユーザー情報
	 */
	public User getUser() {
		return this.user;
	}

	
}
