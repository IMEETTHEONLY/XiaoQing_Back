package com.xueyao.xiaoqing.controller;


import com.xueyao.xiaoqing.pojo.Result;
import com.xueyao.xiaoqing.pojo.User;
import com.xueyao.xiaoqing.pojo.UserAccept;
import com.xueyao.xiaoqing.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody UserAccept user) {
        userService.register(user.getUsername(), user.getPassword());
        return Result.success();
    }

    @GetMapping("/login")
    public Result login(@RequestParam  String username,  String password) {
        String token = userService.login(username, password);
       // System.out.println(token);
        return Result.success(token);
    }

    //根据token里面的id获取用户信息
    @GetMapping("/userinfo")
    public Result<User> userinfo() {
        User u = userService.getUserInfo();
        return Result.success(u);
    }

    @PutMapping("/update")
    public Result update(@RequestParam String nickname) {
        userService.updateNickname(nickname);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> pwdMap) {
        userService.updatePwd(pwdMap);
        return Result.success();
    }

    @PatchMapping("/updateSign")
    public Result updateSign(@RequestParam String new_sign) {
        userService.updateSign(new_sign);
        return Result.success();
    }

    @PutMapping("/bindEds")
    public Result bindEds(@RequestBody Map<String, String> eds) {
        userService.updateEds(eds);
        return Result.success();
    }

    //根据用户id获取用户信息
    @GetMapping("/getUserById")
    public Result getUserById(@RequestParam Integer id){
        User user = userService.getUserById(id);
        return Result.success(user);
    }
}
