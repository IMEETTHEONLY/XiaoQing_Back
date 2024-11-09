package com.xueyao.xiaoqing.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    @Insert("insert into post(content, create_user, create_time, update_time) values (#{content},#{userId},now(),now())")
    void addPost(Integer userId, String content);
}
