package com.limyel.blog.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.convert.PostConvert;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.service.CommentService;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.service.PostTagService;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.PostSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao dao;

    @Autowired
    private PostTagService postTagService;

    @Autowired
    private CommentService commentService;

    public PageData<PostSimpleVO> getPage(PostPageDTO dto) {
        // todo tag 不存在
        Page<PostEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        dao.selectPageSql(page, dto.getTagId());
        List<PostSimpleVO> list = page.getRecords().stream()
                .map(PostConvert.INSTANCE::toSimpleVO)
                .collect(Collectors.toList());
        list.forEach(item -> {
            item.setTags(postTagService.listTagByPost(item.getId()));
            item.setCommentNum(commentService.countByPost(item.getId()));
        });
        return new PageData<>(page, list);
    }

}
