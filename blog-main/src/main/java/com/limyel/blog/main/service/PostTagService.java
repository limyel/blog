package com.limyel.blog.main.service;

import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.PostTagDao;
import com.limyel.blog.main.entity.PostTagEntity;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.tag.TagVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostTagService {

    @Autowired
    private PostTagDao postTagDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<TagVO> listTagByPost(Long postId) {
        List<TagEntity> tags = postTagDao.selectByPost(postId);
        return tags.stream()
                .map(TagConvert.INSTANCE::toVO)
                .toList();
    }

    public Long countPostByTag(Long tagId) {
        LambdaQueryWrapper<PostTagEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PostTagEntity::getTagId, tagId);
        return postTagDao.selectCount(wrapper);
    }

    public void addPostTags(Long postId, List<Long> tagIds) {
        List<PostTagEntity> postTagList = tagIds.stream()
                .map(tagId -> {
                    PostTagEntity item = new PostTagEntity();
                    item.setPostId(postId);
                    item.setTagId(tagId);
                    return item;
                }).toList();

        MybatisBatch<PostTagEntity> mybatisBatch = new MybatisBatch<>(sqlSessionFactory, postTagList);
        MybatisBatch.Method<PostTagEntity> method = new MybatisBatch.Method<>(PostTagDao.class);
        mybatisBatch.execute(method.insert());
    }

    public void deleteByPost(Long postId) {
        postTagDao.deleteByPost(postId);
    }

}
