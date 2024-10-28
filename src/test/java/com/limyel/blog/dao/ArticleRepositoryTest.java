package com.limyel.blog.dao;

import com.limyel.blog.model.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


public class ArticleRepositoryTest {

    private ArticleRepository articleRepository;

    @Test
    public void testSaveArticle() {
        ArticleEntity article = new ArticleEntity();
        article.setDesc("test");
        article.setSlug("test");
        article.setContent("test");
        article.setStatus(1);
        article.setTop(false);
        article.setTitle("test");
        article = articleRepository.save(article);

        List<ArticleEntity> list = articleRepository.findAll();
        System.out.println(list);

    }

}
