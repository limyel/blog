package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.main.AdminTagConvert;
import com.limyel.blog.admin.dto.main.AdminTagDTO;
import com.limyel.blog.admin.vo.main.AdminTagSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.TagDao;
import com.limyel.blog.main.entity.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminTagService {

    @Autowired
    private TagDao dao;

    @Autowired
    private AdminPostTagService postTagService;

    public PageData<AdminTagSimpleVO> getPage(PageParam pageParam) {
        Page<TagEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<AdminTagSimpleVO> list = page.getRecords().stream()
                .map(item -> {
                    AdminTagSimpleVO result = AdminTagConvert.INSTANCE.toSimpleVO(item);
                    result.setPostNum(postTagService.countPostByTag(item.getId()));
                    return result;
                })
                .collect(Collectors.toList());
        return new PageData<>(page, list);
    }

    public AdminTagDTO get(Long id) {
        TagEntity tag = dao.selectById(id);
        return AdminTagConvert.INSTANCE.toDTO(tag);
    }

    public void add(AdminTagDTO dto) {
        TagEntity tag = AdminTagConvert.INSTANCE.toEntity(dto);
        dao.insert(tag);
    }

    public void update(AdminTagDTO dto) {
        TagEntity tag = AdminTagConvert.INSTANCE.toEntity(dto);
        dao.updateById(tag);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

}
