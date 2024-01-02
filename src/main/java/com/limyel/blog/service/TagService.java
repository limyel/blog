package com.limyel.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.dto.TagDTO;
import com.limyel.blog.entity.TagEntity;

import java.util.List;

public interface TagService {

    List<TagEntity> list();

    IPage<TagEntity> list(int pageNum, int pageSize);

    List<TagEntity> all();

    TagDTO get(Long id);

    TagEntity getBySlug(String slug);

    void add(TagDTO dto);

    void update(TagDTO dto);

    void delete(Long id);

}
