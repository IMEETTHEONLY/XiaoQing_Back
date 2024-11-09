package com.xueyao.xiaoqing.service.Impl;

import com.xueyao.xiaoqing.mapper.PostMapper;
import com.xueyao.xiaoqing.pojo.PageBean;
import com.xueyao.xiaoqing.pojo.Post;
import com.xueyao.xiaoqing.pojo.Result;
import com.xueyao.xiaoqing.service.PostService;
import com.xueyao.xiaoqing.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    //注入mapper
    @Autowired
    private PostMapper postMapper;
    //增加帖子
    @Override
    public void addPost(String content) {
           //获取当前线程的用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        //Integer id = (Integer) map.get("id");

        postMapper.addPost(1, content);
    }
    //删除帖子并删除帖子下面的评论
    @Override
    public void deletePost(Integer id) {
        //调用mapper删除帖子下面的评论
        postMapper.deleteComment(id);
        //调用mapper删除帖子
        postMapper.deletePost(id);

    }
    //分页获取帖子
    @Override
    public PageBean getPost(Integer page, Integer pageSize, String name) {
        //1.获取数据的总条数
        Long count = postMapper.count();

        //2.获取需要分页展示的数据   计算出起始条和结束条  从page((page-1)*pageSize查询pageSize条
        List<Post> list = postMapper.page((page - 1) * pageSize, pageSize, name);

        //封装成为PageBean对象
        return new PageBean(count, list);

    }

}

