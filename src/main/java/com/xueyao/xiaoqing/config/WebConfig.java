package com.xueyao.xiaoqing.config;

import com.xueyao.xiaoqing.interceptors.LoginInterceptor;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;


// Web配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 注入拦截器
    @Autowired
    private LoginInterceptor loginInterceptor;
    private ServletRequest servletRequest;
    private ServletResponse servletResponse;

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将拦截器注册到容器中
        // 不拦截登陆和注册
        // 如果有其他不需要拦截的接口，可以在这里添加
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login", "/user/register");
    }






}
