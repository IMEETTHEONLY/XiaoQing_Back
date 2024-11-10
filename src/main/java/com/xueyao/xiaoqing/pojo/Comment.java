package com.xueyao.xiaoqing.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    //帖子id
    private Integer id;
    //评论内容
    private String content;
    @JsonProperty("create_user")   //将属性名映射为create_user(前端传递的字段和属性不一样的时候使用)
    //评论用户id
    private Integer createUser;
    @JsonProperty("master_id")      //将属性名映射为master_id(前端传递的字段和属性不一样的时候使用)
    //父评论id
    private Integer masterId;
    //点赞量
    private Integer likes;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
    @JsonProperty("post_id")      //将属性名映射为master_id(前端传递的字段和属性不一样的时候使用)
    //评论帖子id
    private Integer postId;


}
