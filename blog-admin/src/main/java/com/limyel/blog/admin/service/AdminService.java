package com.limyel.blog.admin.service;

import com.limyel.blog.admin.vo.AboutVO;
import com.limyel.blog.admin.vo.SiteInfoVO;

public interface AdminService {

    SiteInfoVO getSiteInfo();

    AboutVO getAbout();

}
