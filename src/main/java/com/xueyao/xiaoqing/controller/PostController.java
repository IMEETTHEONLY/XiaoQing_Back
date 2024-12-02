package com.xueyao.xiaoqing.controller;

import com.xueyao.xiaoqing.pojo.PageBean;
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



    //删除帖子
    @DeleteMapping("/delete")
    public Result deletePost(@RequestParam Integer id){
        log.info("删除帖子，id为：{}", id);
        //调用postService的方法进行业务处理
        postService.deletePost(id);
        return Result.success();
    }



    //查询帖子，如果说有条件根据条件查询帖子
    @GetMapping("/get")

    public Result gegPost(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer page_size, String name){
        log.info("查询帖子，页码为：{}，页大小为：{}，关键字为：{}", page, page_size, name);
        //调用service分页查询
        PageBean post = postService.getPost(page, page_size, name);

       return Result.success(post);
    }

}

