package com.limyel.blog.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    public static final String JWT_PAYLOAD = "adminId";
    public static final String JWT_HEADER = "authorization";
    public static final String JWT_SPLITER = "abcdefg.uvwxyz";

    public static final char ENCODE_CHAR = 'a';

    public static String generateJwtToken(Long adminId, PrivateKey privateKey, int expire) {
        return Jwts.builder().claim(JWT_PAYLOAD, adminId).setId(createJtl())
                .setExpiration(new Date(System.currentTimeMillis() + expire * 1000))
                .signWith(privateKey, SignatureAlgorithm.RS256).compact();
    }

    public static TokenPayload parseToken(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        TokenPayload payload = new TokenPayload();
        payload.setId(claims.getId());
        payload.setExpiration(claims.getExpiration());
        payload.setAdminId((Long) claims.get(JWT_PAYLOAD));
        return payload;
    }

    private static String createJtl() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }
}
