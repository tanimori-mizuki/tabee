package com.example.form.user;


import lombok.Data;

@Data
public class UpdateUserForm {

    private Integer userId;
    private String name;
    private String imagePath;
    private Integer deleted;
}
