package com.limyel.blog.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao dao;

    public PageData<PostEntity> getPage(PostPageDTO dto) {
        LambdaQueryWrapper<PostEntity> wrapper = Wrappers.lambdaQuery();
        IPage<PostEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());

        if (dto.getTagId() != null) {

        }

        return null;
    }

}
