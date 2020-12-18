package com.example.controller.user;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.domain.user.LoginUser;
import com.example.domain.user.User;
import com.example.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edit_profile")
public class ShowProfileController {

    @Autowired
    private UpdateUserService updateUserService;

    @GetMapping("")
    public User showUserInfo(@AuthenticationPrincipal LoginUser loginUser){
        System.out.println("ログインしてるユーザーID"+loginUser.getUser().getId());
        User profileList = updateUserService.findByUserId(loginUser.getUser().getId());
        return profileList;
    }
}
