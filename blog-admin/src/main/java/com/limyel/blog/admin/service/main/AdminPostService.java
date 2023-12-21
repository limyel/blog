package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.main.AdminPostConvert;
import com.limyel.blog.admin.dto.main.AdminPostDTO;
import com.limyel.blog.admin.vo.main.AdminPostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminPostService {

    @Autowired
    private PostDao dao;

    @Autowired
    private AdminPostTagService postTagService;

    public PageData<AdminPostSimpleVO> getPage(PageParam pageParam) {
        Page<PostEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<AdminPostSimpleVO> list = page.getRecords().stream()
                .map(item -> {
                    AdminPostSimpleVO result = AdminPostConvert.INSTANCE.toSimpleVO(item);
                    result.setTags(postTagService.listTagByPost(item.getId()));
                    return result;
                })
                .collect(Collectors.toList());
        return new PageData<>(page, list);
    }

    public AdminPostDTO get(Long id) {
        PostEntity post = dao.selectById(id);
        AdminPostDTO result = AdminPostConvert.INSTANCE.toDTO(post);
        result.setTagIdList(postTagService.listTagIdByPost(result.getId()));
        return result;
    }

    public void add(AdminPostDTO dto) {
        PostEntity post = AdminPostConvert.INSTANCE.toEntity(dto);
        dao.insert(post);
        postTagService.addPostTags(post.getId(), dto.getTagIdList());
    }

    public void update(AdminPostDTO dto) {
        PostEntity post = AdminPostConvert.INSTANCE.toEntity(dto);
        dao.updateById(post);
        postTagService.deleteByPost(post.getId());
        postTagService.addPostTags(post.getId(), dto.getTagIdList());
    }

    public void delete(Long id) {
        dao.deleteById(id);
        postTagService.deleteByPost(id);
    }

}
