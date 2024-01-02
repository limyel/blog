package com.limyel.blog.service;

import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.entity.TagEntity;

import java.util.List;

public interface PostTagService {

    List<TagEntity> listTagByPost(Long postId);

    List<Long> listTagIdByPost(Long postId);

    List<PostEntity> listPostByTag(Long tagId);

    int countPostByTag(Long tagId);

    void addPostTags(Long postId, List<Long> tagIdList);

    void deleteByPost(Long postId);

    void deleteByTag(Long tagId);


}
