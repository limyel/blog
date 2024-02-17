package com.limyel.blog.main.service.impl;

import com.limyel.blog.main.dao.CategoryDao;
import com.limyel.blog.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

}
