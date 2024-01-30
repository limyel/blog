package com.limyel.blog.main.dao;

import com.limyel.blog.main.entity.PostTagDO;
import com.limyel.blog.main.entity.TagDO;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostTagDao extends BaseDao<PostTagDO> {

    List<TagDO> selectByPost(Long postId);

    Integer deleteByPost(Long postId);

    Integer deleteByTag(Long tagId);

}
