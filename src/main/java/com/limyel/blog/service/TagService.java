package com.limyel.blog.service;

import com.limyel.blog.dao.ArticleTagReposiroty;
import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.model.entity.ArticleTagEntity;
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

    private final ArticleTagReposiroty articleTagReposiroty;

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

    public List<TagListVO> listByArticle(Long articleId) {
        List<Long> tagIds = articleTagReposiroty.findByArticleId(articleId).stream()
                .map(ArticleTagEntity::getTagId)
                .toList();
        if (tagIds.isEmpty()) {
            return List.of();
        }

        List<TagEntity> tags = tagRepository.findByIdIn(tagIds);
        return tags.stream().map(tag -> {
            TagListVO tagListVO = new TagListVO();
            BeanUtils.copyProperties(tag, tagListVO);
            return tagListVO;
        }).toList();
    }

}
