package com.limyel.blog.admin.convert.main;

import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.main.entity.PostEntity;
import org.mapstruct.factory.Mappers;

public interface AdminPostConvert {

    AdminPostConvert INSTANCE = Mappers.getMapper(AdminPostConvert.class);

    PostSimpleVO toSimpleVO (PostEntity post);

}
