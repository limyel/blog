package com.limyel.blog.service;

import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.model.entity.TagEntity;
import com.limyel.blog.model.vo.TagListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<TagListVO> list() {
        List<TagListVO> result = new ArrayList<>();

        List<TagEntity> tags = tagRepository.findAll();
        for (TagEntity tag : tags) {
            TagListVO tagListVO = new TagListVO();
            BeanUtils.copyProperties(tag, tagListVO);
            result.add(tagListVO);
        }

        return result;
    }

}
