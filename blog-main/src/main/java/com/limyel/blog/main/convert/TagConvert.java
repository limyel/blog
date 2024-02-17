package com.limyel.blog.main.convert;

import com.limyel.blog.main.dto.tag.TagAdminDTO;
import com.limyel.blog.main.vo.tag.TagVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagConvert {

    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagVO toVO(TagDO tag);

    TagAdminDTO toDTO(TagVO vo);

    TagDO toEntity(TagAdminDTO dto);

}
