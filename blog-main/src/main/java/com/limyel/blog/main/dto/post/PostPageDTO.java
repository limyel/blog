package com.limyel.blog.main.dto.post;

import com.limyel.blog.web.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostPageDTO extends PageParam {

    private List<Long> tagIds;

}
