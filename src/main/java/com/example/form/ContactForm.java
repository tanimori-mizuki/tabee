package com.example.form;

import lombok.Data;

/**
 *
 * パラメータを受け取るフォーム.
 *
 */
@Data
public class ContactForm {

    /* 名前　*/
    private String name;
    /* Eメールアドレス */
    private String email;
    /* 問合せ内容 */
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
