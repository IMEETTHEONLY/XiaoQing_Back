package com.xueyao.xiaoqing.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    @NotNull
    private Integer id;

    @Pattern(regexp = "^\\S{5,12}$")
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String stunumber;

    @Pattern(regexp = "^\\S{1,15}$")
    private String nickname;
    private String avatar;
    private String signature;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
