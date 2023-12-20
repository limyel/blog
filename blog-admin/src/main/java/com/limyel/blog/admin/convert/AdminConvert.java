package com.limyel.blog.admin.convert;

import com.limyel.blog.admin.dto.AdminDTO;
import com.limyel.blog.admin.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminConvert {

    AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);

    AdminEntity convertDTO(AdminDTO dto);

    AdminDTO toDTO(AdminEntity admin);

}
