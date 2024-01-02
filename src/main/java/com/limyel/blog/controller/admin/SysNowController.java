package com.limyel.blog.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.common.api.Result;
import com.limyel.blog.dto.NowDTO;
import com.limyel.blog.security.LoginRequired;
import com.limyel.blog.service.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/now")
public class SysNowController {

    @Autowired
    private NowService nowService;

    @LoginRequired
    @GetMapping
    public Result<IPage<NowDTO>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<NowDTO> result = nowService.list(pageNum, pageSize);
        return Result.success(result);
    }

    @LoginRequired
    @GetMapping("/{id}")
    public Result<NowDTO> get(@PathVariable Long id) {
        NowDTO result = nowService.get(id);
        return Result.success(result);
    }

    @LoginRequired
    @PostMapping
    public Result<?> add(@RequestBody NowDTO dto) {
        nowService.add(dto);
        return Result.success();
    }

    @LoginRequired
    @PutMapping
    public Result<?> update(@RequestBody NowDTO dto) {
        nowService.update(dto);
        return Result.success();
    }

    @LoginRequired
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        nowService.delete(id);
        return Result.success();
    }

}
