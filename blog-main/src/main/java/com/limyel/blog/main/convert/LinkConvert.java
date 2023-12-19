package com.limyel.blog.main.convert;

import com.limyel.blog.main.entity.LinkEntity;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.LinkVO;
import com.limyel.blog.main.vo.TagDetailVO;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinkConvert {

    LinkConvert INSTANCE = Mappers.getMapper(LinkConvert.class);

    LinkVO toVO(LinkEntity link);

}
