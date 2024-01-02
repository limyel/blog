package com.limyel.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.blog.entity.PostEntity;
import com.limyel.blog.entity.PostTagEntity;
import com.limyel.blog.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostTagDao extends BaseMapper<PostTagEntity> {

    List<TagEntity> selectTagByPost(Long postId);

    List<PostEntity> selectPostByTag(Long tagId);

    int countByTag(Long tagId);

    int deleteByPost(Long postId);

    int deleteByTag(Long tagId);

}
