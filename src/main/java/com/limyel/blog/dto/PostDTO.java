package com.limyel.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDTO {

    private Long id;

    private String title;

    private String slug;

    private String description;

    private Integer status;

    private List<Long> tagIdList;

    private String content;

    private Long tagId;

}
