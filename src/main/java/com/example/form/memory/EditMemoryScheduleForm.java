package com.example.form.memory;

import lombok.Data;

/**
 * 
 * 思い出投稿用スケジュール編集フォーム.
 * 
 * @author masashi.nose
 *
 */
@Data
public class EditMemoryScheduleForm {

	/** ID */
	private String id;
	/** スケジュールID */
	private String scheduleId;
	/** スケジュールタイトル */
	private String title;
	/** 開始日時 */
	private String startAt;
	/** 終了日時 */
	private String finishAt;
	/** しおりID */
	private String shioriId;
	/** ユーザーID */
	private String userId;
	/** スケジュールアイコンパス */
	private String iconPath;
	/** URL */
	private String url;
	/** 住所 */
	private String address;
	/** 電話 */
	private String tel;
	/** メモ */
	private String memo;
	/** 費用 */
	private String cost;
}
