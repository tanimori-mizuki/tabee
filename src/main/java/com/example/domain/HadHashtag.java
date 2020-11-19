package com.example.domain;

import lombok.Data;

@Data
public class HadHashtag {
	/** ID */
	private Integer id;
	/** 思い出ID */
	private Integer memoryId;
	/** ハッシュタグID */
	private Integer hashtagId;
	/** ハッシュタグ情報 */
	private Hashtag hashtag;

}