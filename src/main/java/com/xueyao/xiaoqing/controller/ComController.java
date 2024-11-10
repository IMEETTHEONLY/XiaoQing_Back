package com.xueyao.xiaoqing.controller;

import com.xueyao.xiaoqing.pojo.Comment;
import com.xueyao.xiaoqing.pojo.PageBean;
import com.xueyao.xiaoqing.pojo.Result;
import com.xueyao.xiaoqing.service.ComService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Slf4j
public class ComController {
    @Autowired
    private ComService comService;
    //新增评论
   @PostMapping("/add")
    public Result addComment(@RequestBody  Comment comment){
      log.info( "新增评论，内容：{}", comment.toString());
      //调用service进行业务处理
       comService.addComment(comment);
        return Result.success();
    }

    //删除评论
    @DeleteMapping("/delete")
    public Result deleteComment(@RequestParam Integer id){
        log.info("删除评论，id为：{}", id);
        comService.deleteComment(id);
        return Result.success();
    }


    //分页查询帖子下面的评论
    @GetMapping("get")
    //默认展示第1页，展示10条评论
    public Result getComeList(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int page_size,int post_id){
        log.info("分页查询帖子下面的评论，页码为：{}，页大小为：{}，帖子id为：{}", page, page_size,post_id);
        //调用service分页查询
        PageBean comList = comService.getComList(page, page_size, post_id);
        return Result.success(comList);
    }

    //根据id查询评论
    @GetMapping("/getComById")
    public Result getComById(@RequestParam Integer id){
        log.info("根据id查询评论，id为：{}", id);
       Comment result= comService.getComById(id);
        return Result.success(result);
    }

    //点赞
    @PostMapping("/like")
    public Result like(@RequestParam Integer id){
        log.info("点赞，id为：{}", id);
        comService.addLikes(id);
        return Result.success();
    }
}
