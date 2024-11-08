package com.xueyao.xiaoqing.service.Impl;

import com.xueyao.xiaoqing.mapper.UserMapper;
import com.xueyao.xiaoqing.pojo.User;
import com.xueyao.xiaoqing.service.UserService;
import com.xueyao.xiaoqing.utils.JwtUtil;
import com.xueyao.xiaoqing.utils.RsaUtil;
import com.xueyao.xiaoqing.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        String pwd = RsaUtil.getRSA(password);
        userMapper.register(username, pwd);
    }

    @Override
    public String login(String username, String password) {
        User u = userMapper.getUserByUsername(username);
        if (u == null) {
            throw new RuntimeException("用户名不存在.");
        }
        if (Objects.equals(RsaUtil.getRSA(password), u.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            return JwtUtil.genToken(claims);
        }
        throw new RuntimeException("密码错误.");
    }

    @Override
    public User getUserInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return userMapper.getUserById(id);
    }

    @Override
    public void updateNickname(String nickname) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateNickname(id, nickname);
    }

    @Override
    public void updateAvatar(String avatar) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(id, avatar);
    }

    @Override
    public void updatePwd(Map<String, String> pwdMap) {
        String old_pwd = pwdMap.get("old_pwd");
        String new_pwd = pwdMap.get("new_pwd");
        String re_pwd = pwdMap.get("re_pwd");
        if (!StringUtils.hasLength(old_pwd) || !StringUtils.hasLength(new_pwd) || !StringUtils.hasLength(re_pwd)) {
            throw new RuntimeException("参数错误.");
        }
        if (!Objects.equals(new_pwd, re_pwd)) {
            throw new RuntimeException("两次密码不一致.");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        User u = userMapper.getUserById(id);
        if (!Objects.equals(RsaUtil.getRSA(old_pwd), u.getPassword())) {
            throw new RuntimeException("旧密码错误.");
        }
        userMapper.updatePwd(id, RsaUtil.getRSA(new_pwd));
    }

    @Override
    public void updateSign(String signature) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateSign(id, signature);
    }

    @Override
    public void updateEds(Map<String, String> eds) {
        String stu_number = eds.get("stu_number");
        String eds_psd = eds.get("eds_psd");
        if (!StringUtils.hasLength(stu_number) || !StringUtils.hasLength(eds_psd)) {
            throw new RuntimeException("参数错误.");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateEds(id, stu_number, eds_psd);
    }
}
