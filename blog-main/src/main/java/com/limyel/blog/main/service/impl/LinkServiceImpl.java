package com.limyel.blog.main.service.impl;

import com.limyel.blog.main.convert.LinkConvert;
import com.limyel.blog.main.dao.LinkDao;
import com.limyel.blog.main.entity.LinkEntity;
import com.limyel.blog.main.service.LinkService;
import com.limyel.blog.main.vo.LinkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao dao;

    @Override
    public List<LinkVO> list() {
        List<LinkEntity> list = dao.selectList();
        return list.stream()
                .map(LinkConvert.INSTANCE::toVO)
                .collect(Collectors.toList());
    }
}
