package com.limyel.blog.controller.api;

import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.NowDTO;
import com.limyel.blog.service.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/now")
public class NowController {

    @Autowired
    private NowService nowService;

    @GetMapping
    public Result<NowDTO> get() {
        NowDTO result = nowService.getLatest();
        return Result.success(result);
    }

}
