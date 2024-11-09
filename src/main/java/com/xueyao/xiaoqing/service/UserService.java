package com.xueyao.xiaoqing.service;

import com.xueyao.xiaoqing.pojo.User;
import org.hibernate.validator.constraints.URL;

import java.util.Map;

public interface UserService {
    void register(String username, String password);

    String login(String username, String password);

    User getUserInfo();

    void updateNickname(String nickname);

    void updateAvatar(@URL String avatar);

    void updatePwd(Map<String, String> pwdMap);

    void updateSign(String signature);

    void updateEds(Map<String, String> eds);
}
