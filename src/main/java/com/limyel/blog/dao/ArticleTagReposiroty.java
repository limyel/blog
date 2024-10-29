package com.limyel.blog.dao;

import com.limyel.blog.model.entity.ArticleTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTagReposiroty extends JpaRepository<ArticleTagEntity, Long> {

    List<ArticleTagEntity> findByArticleId(Long articleId);

    int deleteByArticleId(Long articleId);

}
