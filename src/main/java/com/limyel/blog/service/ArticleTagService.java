package com.limyel.blog.service;

import com.limyel.blog.dao.ArticleTagReposiroty;
import com.limyel.blog.model.entity.ArticleTagEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {

    private final ArticleTagReposiroty articleTagReposiroty;

    private final EntityManager entityManager;

    @Transactional
    public int create(Long articleId, List<Long> tagIds) {
        return articleTagReposiroty.saveAll(tagIds.stream().map(tagId -> {
            ArticleTagEntity articleTagEntity = new ArticleTagEntity();
            articleTagEntity.setArticleId(articleId);
            articleTagEntity.setTagId(tagId);
            return articleTagEntity;
        }).toList()).size();
    }

    @Transactional
    public void deleteByArticle(Long articleId) {
        articleTagReposiroty.deleteByArticleId(articleId);
    }

    public List<ArticleTagEntity> listByArticle(Long articleId) {
        return articleTagReposiroty.findByArticleId(articleId);
    }

}
