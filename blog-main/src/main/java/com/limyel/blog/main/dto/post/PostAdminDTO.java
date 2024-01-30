package com.limyel.blog.main.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostAdminDTO {

    private Long id;

    private String title;

    private String description;

    private List<Long> tagIds;

    private Boolean draft;

    private Boolean top;

    private LocalDateTime publishTime;

    private String content;

}
