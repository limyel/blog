package com.limyel.blog.main.dto;

import com.limyel.blog.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPageDTO extends PageParam {

    private Long tagId;

}
