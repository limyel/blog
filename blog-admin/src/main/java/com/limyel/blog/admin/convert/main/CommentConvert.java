package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.vo.main.CommentVO;
import com.limyel.blog.main.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentConvert {

    CommentConvert INSTANCE = Mappers.getMapper(CommentConvert.class);

    CommentVO toVO(CommentEntity comment);

}
