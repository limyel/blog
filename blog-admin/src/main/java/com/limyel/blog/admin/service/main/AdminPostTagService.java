package com.limyel.blog.admin.service.main;

import com.limyel.blog.main.dao.PostTagDao;
import com.limyel.blog.main.entity.PostTagEntity;
import com.limyel.blog.main.service.impl.PostTagServiceImpl;
import com.limyel.blog.main.vo.TagSimpleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminPostTagService extends PostTagServiceImpl {

    @Autowired
    private PostTagDao dao;

    public List<Long> listTagIdByPost(Long postId) {
        return listTagByPost(postId).stream()
                .map(TagSimpleVO::getId)
                .collect(Collectors.toList());
    }

    public void addPostTags(Long postId, List<Long> tagIdList) {
        for (Long tagId : tagIdList) {
            PostTagEntity postTag = new PostTagEntity();
            postTag.setPostId(postId);
            postTag.setTagId(tagId);
            dao.insert(postTag);
        }
    }

    public void deleteByPost(Long postId) {
        dao.deleteByPost(postId);
    }

}
