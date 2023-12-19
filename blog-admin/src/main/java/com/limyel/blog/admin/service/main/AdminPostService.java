package com.limyel.blog.admin.service.main;

import com.limyel.blog.admin.vo.main.PostSimpleVO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.PostDao;
import com.limyel.blog.main.service.PostService;
import com.limyel.blog.main.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPostService extends PostServiceImpl implements PostService {

    @Autowired
    private PostDao dao;

    public PageData<PostSimpleVO> getPage(PageParam pageParam) {
        return null;
    }

}
