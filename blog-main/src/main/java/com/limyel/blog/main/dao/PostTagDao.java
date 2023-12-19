package com.limyel.blog.main.dao;

import com.limyel.blog.main.entity.PostTagEntity;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostTagDao extends BaseDao<PostTagEntity> {

    List<TagEntity> selectByPost(Long postId);

}
