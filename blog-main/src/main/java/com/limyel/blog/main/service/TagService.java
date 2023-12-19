package com.limyel.blog.main.service;

import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.TagDetailVO;
import com.limyel.blog.main.vo.TagSimpleVO;

import java.util.List;

public interface TagService {

    List<TagDetailVO> list();

}
