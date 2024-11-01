package com.limyel.blog.service;

import com.limyel.blog.dao.ArticleTagReposiroty;
import com.limyel.blog.dao.TagRepository;
import com.limyel.blog.model.dto.TagDTO;
import com.limyel.blog.model.entity.ArticleTagEntity;
import com.limyel.blog.model.entity.TagEntity;
import com.limyel.blog.model.vo.TagListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    private final ArticleTagReposiroty articleTagReposiroty;

    public void create(TagDTO dto) {
        TagEntity entity = new TagEntity();
        BeanUtils.copyProperties(dto, entity);
        tagRepository.save(entity);
    }

    public void update(TagDTO dto) {
        TagEntity entity = tagRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("标签不存在"));
        BeanUtils.copyProperties(dto, entity);
        tagRepository.save(entity);
    }

    public TagDTO get(Long id) {
        return tagRepository.findById(id).map(tag -> {
            TagDTO dto = new TagDTO();
            BeanUtils.copyProperties(tag, dto);
            return dto;
        }).orElseThrow(() -> new RuntimeException("标签不存在"));
    }

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

    public Page<TagEntity> page(int pageNum, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        return tagRepository.findAll(pageable);
    }

    public List<TagEntity> listAll() {
        return tagRepository.findAll();
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
