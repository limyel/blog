package com.limyel.blog.main.vo.post;

import com.limyel.blog.main.vo.tag.TagVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostSimpleVO extends PostVO {

    private String description;

    private Boolean top;

    // todo 更新时间、更新记录

}
