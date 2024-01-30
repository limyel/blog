package com.limyel.blog.main.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.main.entity.PostDO;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostDao extends BaseDao<PostDO> {

    IPage<PostDO> selectPageSql(Page<PostDO> page, @Param("tagId") Long tagId);

}
