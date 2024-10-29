package com.limyel.blog.service;

import com.limyel.blog.dao.ArticleTagReposiroty;
import com.limyel.blog.model.entity.ArticleTagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {

    private final ArticleTagReposiroty articleTagReposiroty;

    public int create(Long articleId, List<Long> tagIds) {
        articleTagReposiroty.deleteAllByArticleId(articleId);

        return articleTagReposiroty.saveAll(tagIds.stream().map(tagId -> {
            ArticleTagEntity articleTagEntity = new ArticleTagEntity();
            articleTagEntity.setArticleId(articleId);
            articleTagEntity.setTagId(tagId);
            return articleTagEntity;
        }).toList()).size();
    }

}
