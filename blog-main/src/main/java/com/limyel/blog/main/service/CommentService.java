package com.limyel.blog.main.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.main.dao.CommentDao;
import com.limyel.blog.main.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public Long countByPost(Long postId) {
        LambdaQueryWrapper<CommentEntity> wrapperPlus = Wrappers.lambdaQuery();
        wrapperPlus.eq(CommentEntity::getPostId, postId);
        return commentDao.selectCount(wrapperPlus);
    }

}
