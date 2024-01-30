package com.limyel.blog.main.service;

import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.PostTagDao;
import com.limyel.blog.main.entity.PostTagDO;
import com.limyel.blog.main.entity.TagDO;
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
        List<TagDO> tags = postTagDao.selectByPost(postId);
        return tags.stream()
                .map(TagConvert.INSTANCE::toVO)
                .toList();
    }

    public Long countPostByTag(Long tagId) {
        LambdaQueryWrapper<PostTagDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PostTagDO::getTagId, tagId);
        return postTagDao.selectCount(wrapper);
    }

    public void addPostTags(Long postId, List<Long> tagIds) {
        List<PostTagDO> postTagList = tagIds.stream()
                .map(tagId -> {
                    PostTagDO item = new PostTagDO();
                    item.setPostId(postId);
                    item.setTagId(tagId);
                    return item;
                }).toList();

        MybatisBatch<PostTagDO> mybatisBatch = new MybatisBatch<>(sqlSessionFactory, postTagList);
        MybatisBatch.Method<PostTagDO> method = new MybatisBatch.Method<>(PostTagDao.class);
        mybatisBatch.execute(method.insert());
    }

    public void deleteByPost(Long postId) {
        postTagDao.deleteByPost(postId);
    }

    public void deleteByTag(Long tagId) {
        postTagDao.deleteByTag(tagId);
    }

}
