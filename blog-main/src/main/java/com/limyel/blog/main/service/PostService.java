package com.limyel.blog.main.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.main.convert.PostConvert;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.dto.post.PostAdminDTO;
import com.limyel.blog.main.dto.post.PostPageDTO;
import com.limyel.blog.main.entity.PostEntity;
import com.limyel.blog.main.vo.post.PostArchiveVO;
import com.limyel.blog.main.vo.post.PostDetailVO;
import com.limyel.blog.main.vo.post.PostSimpleVO;
import com.limyel.blog.main.vo.post.PostVO;
import com.limyel.blog.main.vo.tag.TagVO;
import com.limyel.blog.mybatis.pojo.PageData;
import com.limyel.blog.web.pojo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostTagService postTagService;

    @Autowired
    private CommentService commentService;

    public PageData<PostSimpleVO> page(PostPageDTO dto) {
        // todo tag 不存在
        Page<PostEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        postDao.selectPageSql(page, dto.getTagId());
        List<PostEntity> records = page.getRecords();
        setTags(records);
        setCommentNum(records);

        List<PostSimpleVO> list = records.stream()
                .map(PostConvert.INSTANCE::toSimpleVO)
                .toList();
        return new PageData<>(page, list);
    }

    public PostDetailVO get(Long id) {
        PostEntity post = postDao.selectById(id);
        setTags(Collections.singletonList(post));
        setCommentNum(Collections.singletonList(post));

        return PostConvert.INSTANCE.toDetailVO(post);
    }

    public Map<Integer, List<PostArchiveVO>> archive() {
        LambdaQueryWrapper<PostEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostEntity::getDraft, false);
        queryWrapper.orderByDesc(PostEntity::getPublishTime);
        List<PostEntity> postList = postDao.selectList(queryWrapper);

        Map<Integer, List<PostArchiveVO>> result = new HashMap<>();
        postList.forEach(post -> {
            LocalDateTime publishTime = post.getPublishTime();
            Integer year = publishTime.getYear();
            if (!result.containsKey(year)) {
                result.put(year, new ArrayList<>());
            }
            result.get(year).add(PostConvert.INSTANCE.toArchiveVO(post));
        });
        return result;
    }


    // admin

    public PageData<PostVO> page(PageParam pageParam) {
        Page<PostEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        postDao.selectPage(page, null);
        List<PostEntity> records = page.getRecords();
        setTags(records);
        setCommentNum(records);

        List<PostVO> list = records.stream()
                .map(PostConvert.INSTANCE::toVO)
                .toList();
        return new PageData<>(page, list);
    }

    public PostAdminDTO adminGet(Long id) {
        PostEntity post = postDao.selectById(id);
        PostAdminDTO result = PostConvert.INSTANCE.toAdminDTO(post);
        setTagIds(result);
        return result;
    }

    public void add(PostAdminDTO dto) {
        PostEntity post = PostConvert.INSTANCE.toEntity(dto);
        postDao.insert(post);

        postTagService.addPostTags(post.getId(), dto.getTagIds());
    }

    public void update(PostAdminDTO dto) {
        PostEntity post = PostConvert.INSTANCE.toEntity(dto);
        postDao.updateById(post);

        postTagService.deleteByPost(post.getId());
        postTagService.addPostTags(post.getId(), dto.getTagIds());
    }

    public void delete(Long id) {
        postTagService.deleteByPost(id);
        postDao.deleteById(id);
    }

    // private

    private void setTags(List<PostEntity> posts) {
        posts.forEach(post -> post.setTags(postTagService.listTagByPost(post.getId())));
    }

    private void setCommentNum(List<PostEntity> posts) {
        posts.forEach(post -> post.setCommentNum(commentService.countByPost(post.getId())));
    }

    private void setTagIds(PostAdminDTO post) {
        List<TagVO> tags = postTagService.listTagByPost(post.getId());
        List<Long> result = tags.stream()
                .map(TagVO::getId)
                .toList();
        post.setTagIds(result);
    }

}
