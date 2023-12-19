package com.limyel.blog.main.convert;

import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.PostSimpleVO;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagConvert {

    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagSimpleVO toSimpleVO(TagEntity tag);

}
