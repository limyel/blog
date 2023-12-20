package com.limyel.blog.admin.service.impl;

import com.limyel.blog.admin.convert.AdminConvert;
import com.limyel.blog.admin.dao.AdminDao;
import com.limyel.blog.admin.dto.AdminDTO;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.entity.AdminEntity;
import com.limyel.blog.admin.service.AdminService;
import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.common.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public TokenVO login(LoginDTO dto) {
        return null;
    }

    @Override
    public AdminDTO get(Long id) {
        AdminEntity admin = dao.selectById(id);
        if (admin == null) {

        }
        AdminDTO result = AdminConvert.INSTANCE.toDTO(admin);
        result.setPassword(null);
        return result;
    }

    @Override
    public void add(AdminDTO dto) {
        AdminEntity admin = AdminConvert.INSTANCE.convertDTO(dto);
        admin.setSalt(EncryptUtil.getSalt());
        admin.setPassword(EncryptUtil.encrypt(admin.getPassword(), admin.getSalt()));

        dao.insert(admin);
    }

    @Override
    public void update(AdminDTO dto) {
        AdminEntity admin = AdminConvert.INSTANCE.convertDTO(dto);
        if (StringUtils.hasText(admin.getPassword())) {
            admin.setSalt(EncryptUtil.getSalt());
            admin.setPassword(EncryptUtil.encrypt(admin.getPassword(), admin.getSalt()));
        }
        dao.updateById(admin);
    }
}
