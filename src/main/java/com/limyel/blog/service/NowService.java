package com.limyel.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.blog.dto.NowDTO;

public interface NowService {

    IPage<NowDTO> list(Integer pageNum, Integer pageSize);

    NowDTO get(Long id);

    NowDTO getLatest();

    void add(NowDTO dto);

    void update(NowDTO dto);

    void delete(Long id);

}
