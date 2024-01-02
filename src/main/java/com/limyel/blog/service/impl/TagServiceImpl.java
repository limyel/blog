package com.limyel.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.dao.TagDao;
import com.limyel.blog.dto.TagDTO;
import com.limyel.blog.entity.TagEntity;
import com.limyel.blog.service.PostTagService;
import com.limyel.blog.service.TagService;
import com.limyel.blog.util.ConvertUtil;
import com.limyel.blog.util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private PostTagService postTagService;

    @Override
    public List<TagEntity> list() {
        List<TagEntity> result = tagDao.selectList(null);
        for (TagEntity item : result) {
            item.setPostNum(postTagService.countPostByTag(item.getId()));
        }
        return result;
    }

    @Override
    public IPage<TagEntity> list(int pageNum, int pageSize) {
        Page<TagEntity> page = Page.of(pageNum, pageSize);
        Page<TagEntity> result = tagDao.selectPage(page, null);
        for (TagEntity item : result.getRecords()) {
            item.setPostNum(postTagService.countPostByTag(item.getId()));
        }
        return result;
    }

    @Override
    public List<TagEntity> all() {
        return tagDao.selectList(null);
    }

    @Override
    public TagDTO get(Long id) {
        TagEntity tag = tagDao.selectById(id);
        return ConvertUtil.sourceToTarget(tag, TagDTO.class);
    }

    @Override
    public TagEntity getBySlug(String slug) {
        LambdaQueryWrapper<TagEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(TagEntity::getSlug, slug);
        TagEntity tag = tagDao.selectOne(queryWrapper);
        if (tag == null) {
            throw new RuntimeException();
        }
        tag.setPostNum(postTagService.countPostByTag(tag.getId()));
        return tag;
    }

    @Override
    public void add(TagDTO dto) {
        TagEntity tag = new TagEntity();
        tag.setName(dto.getName());
        tag.setSlug(SlugUtil.generate(dto.getName()));
        tagDao.insert(tag);
    }

    @Override
    public void update(TagDTO dto) {
        TagEntity tag = ConvertUtil.sourceToTarget(dto, TagEntity.class);
        tagDao.updateById(tag);
    }

    @Override
    public void delete(Long id) {
        tagDao.deleteById(id);
        postTagService.deleteByTag(id);
    }
}
