package com.limyel.blog.main.convert;

import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.tag.TagVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagConvert {

    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagVO toVO(TagEntity tag);

}
