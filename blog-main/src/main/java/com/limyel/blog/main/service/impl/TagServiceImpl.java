package com.limyel.blog.main.service.impl;

import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.service.TagService;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao dao;

    @Override
    public List<TagSimpleVO> listByPost(Long postId) {
        List<TagEntity> list = dao.selectByPost(postId);
        return list.stream()
                .map(TagConvert.INSTANCE::toSimpleVO)
                .collect(Collectors.toList());
    }
}
