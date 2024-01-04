package com.limyel.blog.security.jwt;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class TokenPayload {

    private String id;

    private Long adminId;

    private Date expiration;

}
