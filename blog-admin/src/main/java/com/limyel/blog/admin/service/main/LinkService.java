package com.limyel.blog.admin.service.main;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.blog.admin.convert.main.LinkConvert;
import com.limyel.blog.admin.dto.main.LinkDTO;
import com.limyel.blog.common.pojo.PageData;
import com.limyel.blog.common.pojo.PageParam;
import com.limyel.blog.main.dao.LinkDao;
import com.limyel.blog.main.entity.LinkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("adminLinkService")
public class LinkService {

    @Autowired
    private LinkDao dao;

    public PageData<LinkDTO> getPage(PageParam pageParam) {
        Page<LinkEntity> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        dao.selectPage(page, null);

        List<LinkDTO> list = page.getRecords().stream()
                .map(LinkConvert.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return new PageData<>(page, list);
    }

    public LinkDTO get(Long id) {
        LinkEntity link = dao.selectById(id);
        return LinkConvert.INSTANCE.toDTO(link);
    }

    public void add(LinkDTO dto) {
        LinkEntity link = LinkConvert.INSTANCE.toEntity(dto);
        dao.insert(link);
    }

    public void update(LinkDTO dto) {
        LinkEntity link = LinkConvert.INSTANCE.toEntity(dto);
        dao.updateById(link);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

}
