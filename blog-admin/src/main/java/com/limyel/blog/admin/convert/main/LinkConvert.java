package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.dto.main.LinkDTO;
import com.limyel.blog.main.entity.LinkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinkConvert {

    LinkConvert INSTANCE = Mappers.getMapper(LinkConvert.class);

    LinkDTO toDTO(LinkEntity link);

    LinkEntity toEntity(LinkDTO dto);

}
