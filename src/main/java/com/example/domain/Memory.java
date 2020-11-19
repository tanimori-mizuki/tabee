package com.example.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 思い出情報のドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memory {
	/** ID */
	private Integer id;
	/** しおりID */
	private Integer shioriId;
	/** ユーザーID */
	private Integer userId;
	/** タイトル */
	private String title;
	/** 内容 */
	private String content;
	/** 公開設定 */
	private boolean isPublicSche;
	/** 投稿日時 */
	private LocalDateTime postAt;
	/** しおり情報 */
	private Shiori shiori;
	/** ユーザー情報 */
	private User user;

}