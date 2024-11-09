package com.xueyao.xiaoqing.service.Impl;

import com.xueyao.xiaoqing.mapper.PostMapper;
import com.xueyao.xiaoqing.pojo.Result;
import com.xueyao.xiaoqing.service.PostService;
import com.xueyao.xiaoqing.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    //注入mapper
    @Autowired
    private PostMapper postMapper;

    @Override
    public void addPost(String content) {
           //获取当前线程的用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        //Integer id = (Integer) map.get("id");

        postMapper.addPost(1, content);
    }

}

