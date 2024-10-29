package com.limyel.blog.dao;

import com.limyel.blog.model.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findByCreateTimeBetweenOrderByCreateTimeDesc(LocalDateTime start, LocalDateTime end);

    ArticleEntity findBySlug(String slug);

    @Query("select year(createTime) from ArticleEntity group by year(createTime)")
    List<Integer> findYearByCreateTime();

}
