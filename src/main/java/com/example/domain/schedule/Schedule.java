package com.example.domain.schedule;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.domain.shiori.Shiori;
import com.example.domain.user.User;

import lombok.Data;

/**
 * スケジュール情報のドメイン
 * 
 * @author masashi.nose
 *
 */
@Data
public class Schedule {
	/** ID */
	private Integer id;
	/** しおりID */
	private Integer shioriId;
	/** タイトル */
	private String title;
	/** 開始日時 */
	private LocalDateTime startAt;
	/** 終了日時 */
	private LocalDateTime finishAt;
	/** アイコンID */
	private Integer iconId;
	/** 目的地 */
	private String destination;
	/** 住所 */
	private String address;
	/** 電話 */
	private String tel;
	/** メモ */
	private String memo;
	/** 費用 */
	private Integer cost;
	/** URL */
	private String url;
	/** 作成者ID */
	private Integer creatorId;
	/** 作成日時 */
	private Date createdAt;
	/** 更新者ID */
	private Integer updaterId;
	/** 更新日時 */
	private Date updatedAt;
	/** バージョン */
	private Integer version;
	/** しおり情報 */
	private Shiori shiori;
	/** スケジュールアイコン情報 */
	private ScheduleIcon scheduleIcon;
	/** ユーザー情報 */
	private User user;

}