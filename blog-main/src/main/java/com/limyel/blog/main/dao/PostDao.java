package com.limyel.blog.main.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostDao extends BaseDao<PostEntity> {

    IPage<PostEntity> selectPageSql(Page<PostEntity> page, @Param("tagId") Long tagId);

}
