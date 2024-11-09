package com.xueyao.xiaoqing.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    //帖子id
    @NotNull
    private int id;

    //帖子内容
    private String content;

    //帖子创建者
    @NotNull
    private User createUser;

    //帖子创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //帖子更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
