package com.xueyao.xiaoqing.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

   @Bean
public CorsFilter corsFilter() {
    // 创建 CORS 配置对象
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();

    // 允许携带凭证（如 cookies 或 Authorization header）
    config.setAllowCredentials(true);

    // 显式允许前端地址
    config.addAllowedOrigin("http://localhost:8081/");  // 去掉尾部的斜杠
    config.addAllowedHeader("*");  // 允许所有请求头
    config.addAllowedMethod("*");  // 允许所有请求方法（GET, POST, PUT, DELETE等）

    // 预检请求的缓存时间
    config.setMaxAge(1800L); // 30分钟

    // 注册 CORS 配置到对应的路径
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
}

}