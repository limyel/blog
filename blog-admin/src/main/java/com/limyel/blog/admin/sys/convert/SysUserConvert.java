package com.limyel.blog.admin.sys.convert;

import com.limyel.blog.admin.sys.entity.SysUserEntity;
import com.limyel.blog.admin.sys.vo.user.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convertToVO(SysUserEntity sysUser);

}
