package com.limyel.blog.main.vo.post;

import com.limyel.blog.main.vo.tag.TagVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDetailVO extends PostVO {

    private String content;

    private Long commentNum;

}
