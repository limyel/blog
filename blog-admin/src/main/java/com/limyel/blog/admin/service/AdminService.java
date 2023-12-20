package com.limyel.blog.admin.service;

import com.limyel.blog.admin.dto.AdminDTO;
import com.limyel.blog.admin.dto.LoginDTO;
import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;
import com.limyel.blog.admin.vo.TokenVO;

public interface AdminService {

    SiteInfoVO getSiteInfo();

    AboutVO getAbout();

    TokenVO login(LoginDTO dto);

    AdminDTO get(Long id);

    void add(AdminDTO dto);

    void update(AdminDTO dto);

}
