package com.limyel.blog.admin.service.main;

import com.limyel.blog.main.dao.PostTagDao;
import com.limyel.blog.main.entity.PostTagEntity;
import com.limyel.blog.main.service.PostTagService;
import com.limyel.blog.main.service.impl.PostTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPostTagService extends PostTagServiceImpl {

    @Autowired
    private PostTagDao dao;

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
