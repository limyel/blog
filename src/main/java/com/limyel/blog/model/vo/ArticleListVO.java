package com.limyel.blog.model.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ArticleListVO {

    private Integer year;

    private List<ArticleListItem> list;

    @Data
    public static class ArticleListItem {

        private Integer monthNum;

        private String month;

        private List<Article> articles;

    }

    @Data
    public static class Article {

        private String title;

        private String slug;

        private String createTime;

    }

}
