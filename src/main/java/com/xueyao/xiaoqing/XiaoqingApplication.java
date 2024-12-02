package com.xueyao.xiaoqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  //加上该注解才可以扫描过滤器（servelt类）
public class XiaoqingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoqingApplication.class, args);
    }

}
