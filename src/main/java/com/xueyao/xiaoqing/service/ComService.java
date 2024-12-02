package com.xueyao.xiaoqing.service;

import com.xueyao.xiaoqing.pojo.Comment;
import com.xueyao.xiaoqing.pojo.PageBean;

import java.util.ArrayList;

public interface ComService {
    //增加评论
    void addComment(Comment comment);
    //删除评论
    void deleteComment(Integer id);
    //分页查询评论
    PageBean getComList(int page, int pageSize, int postId);


    //增加点赞
    void addLikes(Integer id);
    //根据id查询p评论
    Comment getComById(Integer id);

    //根据master_id查询子评论
    ArrayList<Comment> getChildCom(Integer masterId);
}
