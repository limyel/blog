package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.AdminConvert;
import com.limyel.blog.admin.convert.main.AdminPostConvert;
import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminPostService {

    @Autowired
    private PostDao dao;

    @Autowired
    private PostTagService postTagService;

    public PageData<PostSimpleVO> getPage(PageParam pageParam) {
        Page<PostEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<PostSimpleVO> list = page.getRecords().stream()
                .map(item -> {
                    PostSimpleVO result = AdminPostConvert.INSTANCE.toSimpleVO(item);
                    result.setTags(postTagService.listTagByPost(item.getId()));
                    return result;
                })
                .collect(Collectors.toList());
        return new PageData<>(page, list);
    }

}
