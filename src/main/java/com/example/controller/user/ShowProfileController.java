package com.example.controller.user;

import com.example.domain.user.User;
import com.example.service.user.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edit_profile")
public class ShowProfileController {

    @Autowired
    private UpdateUserService updateUserService;

    @GetMapping("")
    public User showUserInfo(Integer userId){
        System.out.println("ログインしてるユーザーID"+userId);
        User profileList = updateUserService.findByUserId(userId);
        return profileList;
    }
}
