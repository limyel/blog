package com.limyel.blog.main.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDetailVO extends PostSimpleVO {

    private Long id;

    private String title;

    private String content;

    private List<TagSimpleVO> tags;

    private LocalDateTime publishTime;

}
