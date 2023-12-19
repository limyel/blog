package com.limyel.blog.main.service;

import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.main.dto.PostPageDTO;
import com.limyel.blog.main.vo.PostDetailVO;
import com.limyel.blog.main.vo.PostSimpleVO;

public interface PostService {

    PageData<PostSimpleVO> getPage(PostPageDTO dto);

    PostDetailVO getDetail(Long id);

}
