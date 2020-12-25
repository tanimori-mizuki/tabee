package com.example.form.user;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * ユーザープロフィールを更新する際に使用するフォームクラス.
 */
@Data
public class UpdateUserForm {
    /* ユーザーID */
    private String id;
    /* ユーザー名 */
    private String name;
    /* アイコン画像パス */
    private MultipartFile imagePath;
    /* 削除フラグ */
    private Integer deleted;
}
