package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.limyel.blog.dao.PostTagDao;
import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.entity.PostTagEntity;
import com.limyel.blog.entity.TagEntity;
import com.limyel.blog.service.PostTagService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostTagServiceImpl implements PostTagService {

    private static final Log mybatisLog = LogFactory.getLog(PostTagServiceImpl.class);

    @Autowired
    private PostTagDao postTagDao;

    @Override
    public List<TagEntity> listTagByPost(Long postId) {
        return postTagDao.selectTagByPost(postId);
    }

    @Override
    public List<Long> listTagIdByPost(Long postId) {
        LambdaQueryWrapper<PostTagEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostTagEntity::getPostId, postId);
        List<PostTagEntity> postTagList = postTagDao.selectList(queryWrapper);
        return postTagList.stream()
                .map(PostTagEntity::getTagId)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostEntity> listPostByTag(Long tagId) {
        return postTagDao.selectPostByTag(tagId);
    }

    @Override
    public int countPostByTag(Long tagId) {
        return postTagDao.countByTag(tagId);
    }

    @Override
    public void addPostTags(Long postId, List<Long> tagIdList) {
        List<PostTagEntity> entityList = tagIdList.stream().map(tagId -> {
            PostTagEntity item = new PostTagEntity();
            item.setPostId(postId);
            item.setTagId(tagId);
            return item;
        }).collect(Collectors.toList());
        String sqlStatement = SqlHelper.getSqlStatement(PostTagDao.class, SqlMethod.INSERT_ONE);
        SqlHelper.executeBatch(PostTagEntity.class, mybatisLog, entityList, entityList.size(), (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));
    }

    @Override
    public void deleteByPost(Long postId) {
        postTagDao.deleteByPost(postId);
    }

    @Override
    public void deleteByTag(Long tagId) {
        postTagDao.deleteByTag(tagId);
    }


}
