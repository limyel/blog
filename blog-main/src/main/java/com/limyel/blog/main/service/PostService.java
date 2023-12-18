package com.limyel.blog.main.service;

import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.entity.PostEntity;

public interface PostService {

    PageData<PostEntity> getPage(PostPageDTO dto);

}
