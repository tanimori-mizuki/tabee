package com.example.domain.shiori;

import lombok.Data;

/**
 * メンバー情報のドメイン.
 * @author yuri.okada
 *
 */
@Data
public class Member {

    /**メンバーID*/
    private Integer id;
    /**しおりID*/
    private Integer shioriId;
    /**ユーザID*/
    private Integer userId;

}