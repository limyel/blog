package com.limyel.blog.admin.dao;

import com.limyel.blog.admin.entity.AdminEntity;
import com.limyel.blog.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao extends BaseDao<AdminEntity> {

}
