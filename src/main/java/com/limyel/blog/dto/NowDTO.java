package com.limyel.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NowDTO {

    private Long id;

    private String content;

    private Date createTime;

}
