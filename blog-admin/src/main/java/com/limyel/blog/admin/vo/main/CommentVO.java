package com.limyel.blog.admin.vo.main;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentVO {

    private Long id;

    private PostSimpleVO post;

    private String nickname;

    private String email;

    private String content;

    private Integer status;

    private LocalDateTime createTime;

}
