package com.example.domain.memory;

import lombok.Data;

/**
 * ブックマーク情報のドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
public class Bookmark {
	/** ID */
	private Integer id;
	/** 思い出ID */
	private Integer memoryId;
	/** ユーザーID */
	private Integer userId;
	/** ユーザー情報 */
	private User user;

}