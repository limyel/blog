package com.limyel.blog.main.controller;

import com.limyel.blog.common.pojo.Result;
import com.limyel.blog.main.service.LinkService;
import com.limyel.blog.main.vo.LinkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/link")
public class LinkController {

    @Autowired
    private LinkService service;

    @GetMapping
    public Result<List<LinkVO>> list() {
        return Result.ok(service.list());
    }

}
