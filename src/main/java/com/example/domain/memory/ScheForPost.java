package com.example.domain.memory;

import java.time.LocalDateTime;

import com.example.domain.schedule.Schedule;
import com.example.domain.shiori.Shiori;
import com.example.domain.user.User;

import lombok.Data;

/**
 * 投稿用スケジュール情報ドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
public class ScheForPost {
	/** ID */
	private Integer id;
	/** スケジュールID */
	private Integer scheduleId;
	/** しおりID */
	private Integer shioriId;
	/** 思い出ID */
	private Integer memoryId;
	/** タイトル */
	private String title;
	/** 開始日時 */
	private LocalDateTime startAt;
	/** 終了日時 */
	private LocalDateTime finishAt;
	/** アイコンID */
	private Integer iconPath;
	/** 電話番号 */
	private String tel;
	/** URL */
	private String url;
	/** 住所 */
	private String address;
	/** メモ */
	private String memo;
	/** 費用 */
	private Integer cost;
	/** 作成者ID */
	private Integer creatorId;
	/** 作成日時 */
	private LocalDateTime createdAt;
	/** 更新者ID */
	private Integer updaterId;
	/** 更新日時 */
	private LocalDateTime updateAt;
	/** スケジュール情報 */
	private Schedule schedule;
	/** しおり情報 */
	private Shiori shiori;
	/** 思い出情報 */
	private Memory memory;
	/** ユーザー情報 */
	private User user;

}