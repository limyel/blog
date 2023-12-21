package com.limyel.blog.admin.vo.main;

import com.limyel.blog.main.vo.TagSimpleVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostSimpleVO {

    private Long id;

    private String title;

    private List<TagSimpleVO> tags;

    private Long commentNum;

    private LocalDateTime publishTime;

}
