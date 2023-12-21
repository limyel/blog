package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.main.TagConvert;
import com.limyel.blog.admin.dto.main.TagDTO;
import com.limyel.blog.admin.vo.main.TagSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.entity.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("adminTagService")
public class TagService {

    @Autowired
    private TagDao dao;

    @Autowired
    private PostTagService postTagService;

    public PageData<TagSimpleVO> getPage(PageParam pageParam) {
        Page<TagEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<TagSimpleVO> list = page.getRecords().stream()
                .map(item -> {
                    TagSimpleVO result = TagConvert.INSTANCE.toSimpleVO(item);
                    result.setPostNum(postTagService.countPostByTag(item.getId()));
                    return result;
                })
                .collect(Collectors.toList());
        return new PageData<>(page, list);
    }

    public TagDTO get(Long id) {
        TagEntity tag = dao.selectById(id);
        return TagConvert.INSTANCE.toDTO(tag);
    }

    public void add(TagDTO dto) {
        TagEntity tag = TagConvert.INSTANCE.toEntity(dto);
        dao.insert(tag);
    }

    public void update(TagDTO dto) {
        TagEntity tag = TagConvert.INSTANCE.toEntity(dto);
        dao.updateById(tag);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

}
