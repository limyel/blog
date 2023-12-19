package com.limyel.blog.main.service.impl;

import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.service.PostTagService;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.TagDetailVO;
import com.limyel.blog.main.vo.TagSimpleVO;
import com.limyel.blog.mybatis.query.LambdaQueryWrapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao dao;

    @Autowired
    private PostTagService postTagService;

    @Override
    public List<TagDetailVO> list() {
        List<TagEntity> list = dao.selectList();
        List<TagDetailVO> result = list.stream()
                .map(TagConvert.INSTANCE::toDetailVO)
                .collect(Collectors.toList());
        result.forEach(item -> item.setPostNum(postTagService.countPostByTag(item.getId())));
        return result;
    }

}
