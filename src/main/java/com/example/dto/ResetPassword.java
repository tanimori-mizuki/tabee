package com.example.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * パスワードリセット用のDTO.
 * 
 * @author masashi.nose
 *
 */
@Data
@AllArgsConstructor
public class ResetPassword {
	/** ID */
	private Integer id;
	/** ユーザーID */
	private Integer userId;
	/** ランダムURL */
	private String randomUrl;
	/** 有効期限 */
	private LocalDateTime expireDate;

}
