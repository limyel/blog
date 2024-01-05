package com.limyel.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.blog.admin.dao.AdminDao;
import com.limyel.blog.admin.dto.AboutDTO;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.entity.AdminEntity;
import com.limyel.blog.admin.vo.TokenVO;
import com.limyel.blog.common.config.BlogConfig;
import com.limyel.blog.common.constant.BlogConstant;
import com.limyel.blog.common.util.RsaUtil;
import com.limyel.blog.common.util.ThreadLocalUtil;
import com.limyel.blog.security.config.UserEntity;
import com.limyel.blog.security.config.UserService;
import com.limyel.blog.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private BlogConfig blogConfig;

    public TokenVO login(LoginDTO dto) {
        AdminEntity admin = adminDao.selectOne(null);
        String token = JwtUtil.generateJwtToken(admin.getId(), RsaUtil.getPrivateKey(), blogConfig.getJwt().getExpire());
        TokenVO result = new TokenVO();
        result.setToken(token);
        return result;
    }

    public String getAbout() {
        AdminEntity admin = adminDao.selectOne(null);
        return admin.getAbout();
    }

    public String getSysAbout() {
        UserEntity user = ThreadLocalUtil.get(BlogConstant.CURRENT_USER, UserEntity.class);
        AdminEntity admin = adminDao.selectById(user.getId());
        return admin.getAbout();
    }

    public void updateAbout(AboutDTO dto) {
        UserEntity user = ThreadLocalUtil.get(BlogConstant.CURRENT_USER, UserEntity.class);
        AdminEntity admin = adminDao.selectById(user.getId());
        admin.setAbout(dto.getAbout());
        adminDao.updateById(admin);
    }

    @Override
    public UserEntity getById(Long id) {
        AdminEntity admin = adminDao.selectById(id);
        return admin;
    }
}
