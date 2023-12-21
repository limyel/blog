package com.limyel.blog.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.main.dao.PostTagDao;
import com.limyel.blog.main.entity.PostTagEntity;
import com.limyel.blog.main.service.PostTagService;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostTagServiceImpl implements PostTagService {

    @Autowired
    private PostTagDao dao;

    @Override
    public List<TagSimpleVO> listTagByPost(Long postId) {
        return null;
    }

    @Override
    public Long countPostByTag(Long tagId) {
        LambdaQueryWrapper<PostTagEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PostTagEntity::getTagId, tagId);
        return dao.selectCount(wrapper);
    }



}
