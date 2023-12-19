package com.limyel.blog.main.convert;

import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.vo.PostDetailVO;
import com.limyel.blog.main.vo.PostSimpleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostConvert {

    PostConvert INSTANCE = Mappers.getMapper(PostConvert.class);

    PostSimpleVO toSimpleVO(PostEntity post);

    PostDetailVO toDetailVO(PostEntity post);

}
