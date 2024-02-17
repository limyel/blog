package com.limyel.blog.main.convert;

import com.limyel.blog.main.dto.post.PostAdminDTO;
import com.limyel.blog.main.vo.post.PostArchiveVO;
import com.limyel.blog.main.vo.post.PostDetailVO;
import com.limyel.blog.main.vo.post.PostSimpleVO;
import com.limyel.blog.main.vo.post.PostVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostConvert {

    PostConvert INSTANCE = Mappers.getMapper(PostConvert.class);

    PostVO toVO(PostDO post);

    PostSimpleVO toSimpleVO(PostDO post);

    PostArchiveVO toArchiveVO(PostDO post);

    PostDetailVO toDetailVO(PostDO post);

    PostAdminDTO toAdminDTO(PostDO post);

    PostDO toEntity(PostAdminDTO dto);

}
