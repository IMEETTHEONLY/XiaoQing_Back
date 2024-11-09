package com.xueyao.xiaoqing.mapper;

import com.xueyao.xiaoqing.pojo.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    //加入新的帖子
    @Insert("insert into post(content, create_user, create_time, update_time) values (#{content},#{userId},now(),now())")
    void addPost(Integer userId, String content);



    //删除帖子同时删除帖子下面的评论
    @Delete("delete from post where id=#{id}")
    void deletePost(Integer id);
    @Delete("delete from comm where post_id=#{id}")
    void deleteComment(Integer id);


    //统计帖子总数量
    @Select("select count(*) from post")
    Long count();
    //条件查询需要展示的帖子
    List<Post> page(int start,int end,String name);

}
