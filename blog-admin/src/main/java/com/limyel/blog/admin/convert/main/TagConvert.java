package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.dto.main.TagDTO;
import com.limyel.blog.admin.vo.main.TagSimpleVO;
import com.limyel.blog.main.entity.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagConvert {

    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagSimpleVO toSimpleVO(TagEntity tag);

    TagDTO toDTO(TagEntity tag);

    TagEntity toEntity(TagDTO dto);

}
