package com.limyel.blog.main.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostSimpleVO {

    private Long id;

    private String title;

    private String description;

    private Long commentNum;

    private List<TagSimpleVO> tags;

    private LocalDateTime publishTime;

}
