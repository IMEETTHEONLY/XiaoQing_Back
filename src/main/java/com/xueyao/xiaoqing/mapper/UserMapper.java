package com.xueyao.xiaoqing.mapper;

import com.xueyao.xiaoqing.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username, password,create_time,update_time) values(#{username}, #{password},now(),now())")
    void register(String username, String password);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);
    //根据token里面的id获取用户信息
    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Update("update user set nickname = #{nickname} where id = #{id}")
    void updateNickname(Integer id, String nickname);

    @Update("update user set avatar = #{avatar} where id = #{id}")
    void updateAvatar(Integer id, String avatar);

    @Update("update user set password = #{password} where id = #{id}")
    void updatePwd(Integer id, String password);

    @Update("update user set signature = #{signature} where id = #{id}")
    void updateSign(Integer id, String signature);

    @Update("update user set stunumber = #{stuNumber}, eds_psd = #{edsPsd} where id = #{id}")
    void updateEds(Integer id, String stuNumber, String edsPsd);

    //根据id获取当前用户的信息
    @Select("select * from user where id = #{id}")
    User getUserInfo(Integer id);
}
