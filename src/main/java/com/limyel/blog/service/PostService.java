package com.limyel.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.dto.PostDTO;
import com.limyel.blog.entity.PostEntity;

import java.util.List;
import java.util.Map;

public interface PostService {

    IPage<PostEntity> list(Integer pageNum, Integer pageSize, PostDTO dto);

    IPage<PostEntity> all(Integer pageNum, Integer pageSize);

    PostEntity get(Long id);

    PostEntity getBySlug(String slug);

    Map<Integer, List<PostEntity>> archive();

    void add(PostDTO dto);

    void update(PostDTO dto);

    void delete(Long id);

}
