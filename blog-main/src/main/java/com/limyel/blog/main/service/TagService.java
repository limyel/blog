package com.limyel.blog.main.service;

import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.tag.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private PostTagService postTagService;

    public List<TagVO> list() {
        List<TagEntity> list = tagDao.selectList(null);
        List<TagVO> result = list.stream()
                .map(TagConvert.INSTANCE::toVO)
                .toList();
        result.forEach(tag -> {
            tag.setPostNum(postTagService.countPostByTag(tag.getId()));
        });
        return result;
    }

    public TagVO get(Long id) {
        TagEntity tag = tagDao.selectById(id);
        return TagConvert.INSTANCE.toVO(tag);
    }

}
