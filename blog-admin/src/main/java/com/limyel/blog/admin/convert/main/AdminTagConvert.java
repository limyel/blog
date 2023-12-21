package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.dto.main.AdminTagDTO;
import com.limyel.blog.admin.vo.main.AdminTagSimpleVO;
import com.limyel.blog.main.entity.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminTagConvert {

    AdminTagConvert INSTANCE = Mappers.getMapper(AdminTagConvert.class);

    AdminTagSimpleVO toSimpleVO(TagEntity tag);

    AdminTagDTO toDTO(TagEntity tag);

    TagEntity toEntity(AdminTagDTO dto);

}
