package com.xueyao.xiaoqing.interceptors;

import com.xueyao.xiaoqing.utils.JwtUtil;
import com.xueyao.xiaoqing.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

//请求拦截器，返回true代表放行，返回false代表不放行
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 令牌验证

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            token = token.substring(7); // 去掉Bearer前缀
        }
        try {
            // 解析token
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 将token携带的信息存放在ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e){
            // 拦截
            System.out.println(request.getRequestURI());
            response.setStatus(401);
            return false;
        }
    }
    // 后置处理
    // 删除ThreadLocal中的数据以防止内存泄漏
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 移除ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
