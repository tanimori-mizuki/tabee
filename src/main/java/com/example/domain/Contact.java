package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ユーザーのドメインクラス.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Integer id;
    private String name;
    private String email;
    private String content;
    private LocalDateTime sendAt;

}