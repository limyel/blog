package com.limyel.blog.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "blog_article")
public class ArticleEntity extends BaseEntity {

    private String title;

    private String slug;

    private String content;

    private Boolean top;

    private Integer status;

    private Integer viewNum;

}
