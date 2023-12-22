package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.main.CommentConvert;
import com.limyel.blog.admin.dto.main.CommentStatusDTO;
import com.limyel.blog.admin.dto.main.PostDTO;
import com.limyel.blog.admin.vo.main.CommentVO;
import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.CommentDao;
import com.limyel.blog.main.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("adminCommentService")
public class CommentService {

    @Autowired
    private CommentDao dao;

    public PageData<CommentVO> getPage(PageParam pageParam) {
        Page<CommentEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<CommentVO> list = page.getRecords().stream()
                .map(CommentConvert.INSTANCE::toVO)
                .collect(Collectors.toList());

        return new PageData<>(page, list);
    }

    public void updateStatus(CommentStatusDTO dto) {
        CommentEntity comment = dao.selectById(dto.getId());
        comment.setStatus(dto.getStatus());
        dao.updateById(comment);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

}
