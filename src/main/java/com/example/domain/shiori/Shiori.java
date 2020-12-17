package com.example.domain.shiori;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * しおり情報のドメイン.
 * 
 * @author yuri.okada
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shiori {
	/** しおりID */
	private Integer id;
	/** タイトル */
	private String title;
	/** 出発日 */
	private Date depAt;
	/** 帰着日 */
	private Date returnAt;
	/** 画像名 */
	private String imagePath;
	/** 費用合計 */
	private Integer totalCost;
	/** 作成者ID */
	private Integer creatorId;
	/** 作成日時 */
	private LocalDateTime createdAt;
	/** 更新者ID */
	private Integer updaterId;
	/** 更新日時 */
	private LocalDateTime updatedAt;
	/** バージョン */
	private Integer version;
	/** ユーザー情報 */
	private User user;
	/** ユーザリスト */
	private List<User> userList;
	/** 目的地リスト */
	private List<Destination> destinationList;

}