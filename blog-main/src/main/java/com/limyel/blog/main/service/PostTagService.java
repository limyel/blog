package com.limyel.blog.main.service;

import com.limyel.blog.main.vo.TagSimpleVO;

import java.util.List;

public interface PostTagService {

    List<TagSimpleVO> listTagByPost(Long postId);

    Long countPostByTag(Long tagId);

}
