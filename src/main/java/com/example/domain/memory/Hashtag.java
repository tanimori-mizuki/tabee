package com.example.domain.memory;

import com.example.domain.user.User;

import lombok.Data;

/**
 * ハッシュタグ情報のドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
public class Hashtag {
	/** ID */
	private Integer id;
	/** ハッシュタグ名 */
	private String name;
	/** ユーザーID */
	private Integer userId;
	/** ユーザー情報 */
	private User user;

}