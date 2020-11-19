package com.example.domain;

import lombok.Data;

/**
 * いいね情報ドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
public class Favorite {
	/** ID */
	private Integer id;
	/** 思い出ID */
	private Integer memoryId;
	/** ユーザーID */
	private Integer userId;
	/** ユーザー情報 */
	private User user;

}