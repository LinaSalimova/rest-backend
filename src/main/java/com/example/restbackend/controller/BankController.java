package com.example.restbackend.controller;

import com.example.restbackend.domain.LoginInfo;
import com.example.restbackend.domain.UserInfo;
import com.example.restbackend.exception.InvalidUsernameException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    Map<String,UserInfo> users = Map.of(
            "Alina", UserInfo.builder().userName("Alina").build(),
            "Anna", UserInfo.builder().userName("Anna").build(),
            "Lena", UserInfo.builder().userName("Lena").build(),
            "Gena", UserInfo.builder().userName("Gena").build(),
            "Andrey", UserInfo.builder().userName("Andrey").build()
    );

    @PostMapping("user/login")
    @ApiOperation("Авторизация")
    @ApiImplicitParam
    public UserInfo doLogin(@RequestBody(required = false) LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Alina")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUsernameException();
        }
    }
    @GetMapping("user/getAll")
    @ApiOperation("Получение всех юзеров")
    public List<UserInfo> getAllUsersInfo() {
        List <UserInfo> result = new ArrayList<>();
        for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
            result.add(entry.getValue());
        }


        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
