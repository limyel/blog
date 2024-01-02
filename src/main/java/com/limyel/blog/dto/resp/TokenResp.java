package com.limyel.blog.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TokenResp {

    private String token;

    private Date expiredTime;

}
