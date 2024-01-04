package com.limyel.blog.main.convert;

import com.limyel.blog.main.dto.post.PostAdminDTO;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.vo.post.PostArchiveVO;
import com.limyel.blog.main.vo.post.PostDetailVO;
import com.limyel.blog.main.vo.post.PostSimpleVO;
import com.limyel.blog.main.vo.post.PostVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostConvert {

    PostConvert INSTANCE = Mappers.getMapper(PostConvert.class);

    PostVO toVO(PostEntity post);

    PostSimpleVO toSimpleVO(PostEntity post);

    PostArchiveVO toArchiveVO(PostEntity post);

    PostDetailVO toDetailVO(PostEntity post);

    PostAdminDTO toAdminDTO(PostEntity post);

    PostEntity toEntity(PostAdminDTO dto);

}
