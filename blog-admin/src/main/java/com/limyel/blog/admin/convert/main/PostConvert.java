package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.dto.main.PostDTO;
import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.main.entity.PostEntity;
import org.mapstruct.factory.Mappers;

public interface PostConvert {

    PostConvert INSTANCE = Mappers.getMapper(PostConvert.class);

    PostSimpleVO toSimpleVO (PostEntity post);

    PostEntity toEntity(PostDTO dto);

    PostDTO toDTO(PostEntity post);

}
