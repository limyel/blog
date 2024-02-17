package com.limyel.blog.main.controller;

import com.limyel.blog.main.service.CategoryService;
import com.limyel.blog.main.vo.CategoryVO;
import com.limyel.blog.web.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result<List<CategoryVO>> list() {
        List<CategoryVO> result = categoryService.list();
        return Result.ok(result);
    }

}
