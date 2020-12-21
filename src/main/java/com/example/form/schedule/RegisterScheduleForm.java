package com.example.form.schedule;

import lombok.Data;

/**
 * 
 * スケジュール登録用フォーム
 * 
 * @author masashi.nose
 *
 */
@Data
public class RegisterScheduleForm {

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
