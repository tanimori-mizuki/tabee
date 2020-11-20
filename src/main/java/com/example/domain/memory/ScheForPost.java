package com.example.domain.memory;

import java.time.LocalDateTime;
import java.util.Date;

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
	private Date finishAt;
	/** アイコンID */
	private Integer iconId;
	/** 電話番号 */
	private String tel;
	/** 目的地 */
	private String destination;
	/** URL */
	private String url;
	/** 住所 */
	private String address;
	/** メモ */
	private String memo;
	/** 費用 */
	private Integer cost;
	/** スケジュール情報 */
	private Schedule schedule;
	/** しおり情報 */
	private Shiori shiori;
	/** 思い出情報 */
	private Memory memory;
	/** スケジュールアイコン情報 */
	private ScheduleIcon scheduleIcon;

}