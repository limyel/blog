package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.constant.BlogConstant;
import com.limyel.blog.dao.PostDao;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.service.PostService;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.util.ConvertUtil;
import com.limyel.blog.util.SlugUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostTagService postTagService;

    @Override
    public IPage<PostEntity> list(Integer pageNum, Integer pageSize, PostDTO dto) {
        LambdaQueryWrapper<PostEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(PostEntity::getId, PostEntity::getTitle, PostEntity::getSlug, PostEntity::getDescription,
                PostEntity::getCreateTime);
        queryWrapper.eq(PostEntity::getStatus, BlogConstant.POST_STATUS_PUBLISHED);
        queryWrapper.orderByDesc(PostEntity::getCreateTime);
        if (dto != null) {
            if (dto.getTagId() != null) {
                List<PostEntity> postList = postTagService.listPostByTag(dto.getTagId());
                List<Long> idList = postList.stream()
                        .map(PostEntity::getId)
                        .collect(Collectors.toList());
                queryWrapper.in(PostEntity::getId, idList);
            }
        }

        Page<PostEntity> page = Page.of(pageNum, pageSize);
        postDao.selectPage(page, queryWrapper);

        setTagList(page.getRecords());

        return page;
    }

    @Override
    public IPage<PostEntity> all(Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<PostEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(PostEntity::getId, PostEntity::getTitle, PostEntity::getSlug, PostEntity::getDescription,
                PostEntity::getCreateTime);
        queryWrapper.orderByDesc(PostEntity::getCreateTime);

        Page<PostEntity> page = Page.of(pageNum, pageSize);
        postDao.selectPage(page, queryWrapper);

        setTagList(page.getRecords());

        return page;
    }

    @Override
    public PostEntity get(Long id) {
        PostEntity result = postDao.selectById(id);
        result.setTagIdList(postTagService.listTagIdByPost(result.getId()));
        return result;
    }

    @Override
    public PostEntity getBySlug(String slug) {
        LambdaQueryWrapper<PostEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostEntity::getSlug, slug);
        PostEntity result = postDao.selectOne(queryWrapper);
        result.setTagList(postTagService.listTagByPost(result.getId()));
        return result;
    }

    @Override
    public Map<Integer, List<PostEntity>> archive() {
        LambdaQueryWrapper<PostEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostEntity::getStatus, BlogConstant.POST_STATUS_PUBLISHED);
        queryWrapper.orderByDesc(PostEntity::getCreateTime);
        List<PostEntity> postList = postDao.selectList(queryWrapper);

        Map<Integer, List<PostEntity>> result = new HashMap<>();
        postList.forEach(post -> {
            Date createTime = post.getCreateTime();
            Integer year = createTime.getYear() + 1900;
            if (!result.containsKey(year)) {
                result.put(year, new ArrayList<>());
            }
            result.get(year).add(post);
        });
        return result;
    }

    @Override
    public void add(PostDTO dto) {
        PostEntity post = ConvertUtil.sourceToTarget(dto, PostEntity.class);
        post.setSlug(SlugUtil.generate(dto.getTitle()));
        postDao.insert(post);
        postTagService.addPostTags(post.getId(), dto.getTagIdList());
    }

    @Override
    public void update(PostDTO dto) {
        PostEntity post = postDao.selectById(dto.getId());
        BeanUtils.copyProperties(dto, post);
        postDao.updateById(post);
    }

    @Override
    public void delete(Long id) {
        postTagService.deleteByPost(id);
        postDao.deleteById(id);
    }

    private void setTagList(List<PostEntity> postList) {
        for (PostEntity item : postList) {
            item.setTagList(postTagService.listTagByPost(item.getId()));
        }
    }
}
