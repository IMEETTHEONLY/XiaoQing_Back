package com.xueyao.xiaoqing.service.Impl;

import com.xueyao.xiaoqing.mapper.ComMapper;
import com.xueyao.xiaoqing.pojo.Comment;
import com.xueyao.xiaoqing.pojo.PageBean;
import com.xueyao.xiaoqing.service.ComService;
import com.xueyao.xiaoqing.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ComServiceImpl implements ComService {
    //导入mapper接口
    @Autowired
    private  ComMapper comMapper;
    //增加评论
    @Override
    public void addComment(Comment comment) {
        //通过线程获得当前用户的id
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userID= (Integer) map.get("id");
        //将comment的userid设置为当前用户的id
        comment.setCreateUser(userID);
        //将comment的likes设置为0
        comment.setLikes(0);
        comMapper.addComment(comment.getContent(),userID,comment.getMasterId(),comment.getLikes(),comment.getPostId());

    }

    @Override
    public void deleteComment(Integer id) {
        //调用mapeer接口删除评论即可
        comMapper.deleteComment(id);
    }

    @Override
    public PageBean getComList(int page, int pageSize, int postId) {
        //查询该帖子下面一共有多少条帖子
        Long total = comMapper.count();
        //查询要展示在当前页面的数据
        //(page-1)*pageSize起始行数，pageSize每页显示的条数
        int start=(page - 1) * pageSize;
        List<Comment> pages = comMapper.page(start, pageSize, postId);

        //将总条数和当前展示的数据封装到PageBean对象中
        return new PageBean(total,pages);
    }

    @Override
    public void addLikes(Integer id) {
        //先将原先的点赞量查询出来
        Comment com = comMapper.getComById(id);
        //获得点赞量
        Integer likes = com.getLikes();
        //调用mapper接口增加点赞数即可
        comMapper.addlikes(id,likes);
    }

    @Override
    public Comment getComById(Integer id) {
        return comMapper.getComById(id);
    }
    //根据master_id查询所有子评论
    @Override
    public ArrayList<Comment> getChildCom(Integer masterId) {
        return  comMapper.getChildCom(masterId);
    }


}
