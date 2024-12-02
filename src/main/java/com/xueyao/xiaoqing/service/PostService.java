package com.xueyao.xiaoqing.service;

import com.xueyao.xiaoqing.pojo.PageBean;
import com.xueyao.xiaoqing.pojo.Post;
import com.xueyao.xiaoqing.pojo.User;

import java.util.ArrayList;

public interface PostService {
    void addPost(String content);

//    void deletePost(Integer id);
























    PageBean getPost(Integer page, Integer pageSize, String name);

    void deletePost(Integer id);
}
