package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {

	/** ID */
	private Long id;
	/** ユーザー名 */
	private String name;
	/** メールアドレス */
	private String email;
	/** パスワード */
	private String password;
	/** 登録日時 */
	private Timestamp createdAt;
	/** 更新日時 */
	private Timestamp updatedAt;
	/** 画像パス */
	private String imagePath;
	/** 削除フラグ */
	private boolean deleted;

}