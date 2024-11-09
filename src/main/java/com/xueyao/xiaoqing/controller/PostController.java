package com.xueyao.xiaoqing.controller;

import com.xueyao.xiaoqing.pojo.Post;
import com.xueyao.xiaoqing.pojo.Result;
import com.xueyao.xiaoqing.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {
    //注入postService
    @Autowired
    private PostService postService;

    //新增帖子
    @PostMapping("/add")
    public Result addPost(@RequestBody Post post){
        log.info("新增帖子，内容：{}", post.getContent());
        //调用postService的方法进行业务处理
        postService.addPost(post.getContent());
        return Result.success();

    }
}

