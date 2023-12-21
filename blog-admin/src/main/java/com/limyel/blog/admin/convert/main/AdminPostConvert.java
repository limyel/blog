package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.dto.main.AdminPostDTO;
import com.limyel.blog.admin.vo.main.AdminPostSimpleVO;
import com.limyel.blog.main.entity.PostEntity;
import org.mapstruct.factory.Mappers;

public interface AdminPostConvert {

    AdminPostConvert INSTANCE = Mappers.getMapper(AdminPostConvert.class);

    AdminPostSimpleVO toSimpleVO (PostEntity post);

    PostEntity toEntity(AdminPostDTO dto);

    AdminPostDTO toDTO(PostEntity post);

}
