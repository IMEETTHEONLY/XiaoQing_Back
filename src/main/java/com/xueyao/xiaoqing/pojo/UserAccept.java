package com.xueyao.xiaoqing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//此类用来接收新注册时的用户名和密码
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccept {
    private  String username;   //接收用户名

    private String password;   //接收密码


}
