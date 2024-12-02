package com.xueyao.xiaoqing.mapper;

import com.xueyao.xiaoqing.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ComMapper {

    //新增评论
    @Insert("insert into comm(content, create_user, master_id, create_time, update_time, post_id) VALUES (#{content},#{userID},#{masterId},now(),now(),#{postId})")
    void addComment(String content, Integer userID, Integer masterId, Integer likes, Integer postId);
    //删除评论
    @Delete("delete from comm where id=#{id}")
    void deleteComment(Integer id);

    //分页查询帖子.
    //先查询一共有多少条帖子
    @Select("select count(*) from comm")
    Long count();

    //查询当前页的数据
   // @Select("select * from comm where post_id=#{postId} limit #{start},#{end} ")
    List<Comment> page(int start, int end, int postId);


    //根据评论id查询评论
    @Select("select * from comm where id=#{id}")
    Comment getComById(Integer id);

    //点赞量+1
    @Update("update comm set likes=likes+1 where id=#{id}")
    void addlikes(Integer id, Integer likes);

    //查询子评论根据master_id
    @Select("select * from comm where master_id=#{masterId}")
    ArrayList<Comment> getChildCom(Integer masterId);
}
