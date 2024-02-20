package com.example.restbackend.controller;

import com.example.restbackend.domain.LoginInfo;
import com.example.restbackend.domain.UserInfo;
import com.example.restbackend.exception.InvalidUsernameException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BankController {

    @PostMapping("user/login")
    @ApiOperation("Авторизация")

    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Alina")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUsernameException();
        }
    }
}
