package com.limyel.blog.main.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.main.convert.TagConvert;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.dto.tag.TagAdminDTO;
import com.limyel.blog.main.entity.TagEntity;
import com.limyel.blog.main.vo.tag.TagVO;
import com.limyel.blog.web.pojo.PageData;
import com.limyel.blog.web.pojo.PageParam;
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

    // admin

    public PageData<TagVO> page(PageParam pageParam) {
        Page<TagEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        tagDao.selectPage(page, null);
        List<TagVO> list = page.getRecords().stream()
                .map(TagConvert.INSTANCE::toVO)
                .toList();
        setPostNum(list);
        return new PageData<>(page, list);
    }

    public List<TagVO> all() {
        List<TagEntity> list = tagDao.selectList();
        return list.stream()
                .map(TagConvert.INSTANCE::toVO)
                .toList();
    }

    public void add(TagAdminDTO dto) {
        TagEntity tag = TagConvert.INSTANCE.toEntity(dto);
        tagDao.insert(tag);
    }

    public void update(TagAdminDTO dto) {
        TagEntity tag = TagConvert.INSTANCE.toEntity(dto);
        tagDao.updateById(tag);
    }

    public void delete(Long id) {
        postTagService.deleteByPost(id);
        tagDao.deleteById(id);
    }

    // private

    private void setPostNum(List<TagVO> tags) {
        tags.forEach(tag -> tag.setPostNum(postTagService.countPostByTag(tag.getId())));
    }

}
