package com.limyel.blog.main.service.impl;

import com.limyel.blog.main.dao.CommentDao;
import com.limyel.blog.main.entity.CommentEntity;
import com.limyel.blog.main.service.CommentService;
import com.limyel.blog.mybatis.query.LambdaQueryWrapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao dao;

    @Override
    public Long countByPost(Long postId) {
        LambdaQueryWrapperPlus<CommentEntity> wrapperPlus = new LambdaQueryWrapperPlus<>();
        wrapperPlus.eq(CommentEntity::getPostId, postId);
        return dao.selectCount(wrapperPlus);
    }

}
