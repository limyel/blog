package com.limyel.blog.admin.service.impl;

import com.limyel.blog.admin.dao.AdminDao;
import com.limyel.blog.admin.entity.AdminEntity;
import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao dao;

    @Override
    public SiteInfoVO getSiteInfo() {
        List<AdminEntity> list = dao.selectList();
        AdminEntity admin = list.get(0);
        return new SiteInfoVO(admin.getSiteName(), admin.getSubSiteName());
    }

    @Override
    public AboutVO getAbout() {
        List<AdminEntity> list = dao.selectList();
        AdminEntity admin = list.get(0);
        return new AboutVO(admin.getAbout());
    }
}
