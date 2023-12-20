package com.limyel.blog.admin.dto.main;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDTO {

    private Long id;

    private String title;

    private String description;

    private String content;

    private Boolean top;

    private Boolean comment;

    private Boolean draft;

    private LocalDateTime publishTime;

    List<Long> tagIdList;

}
