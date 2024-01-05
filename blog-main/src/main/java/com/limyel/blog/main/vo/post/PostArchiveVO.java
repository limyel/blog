package com.limyel.blog.main.vo.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostArchiveVO {

    private Long id;

    private String title;

    private LocalDateTime publishTime;

}
