package com.limyel.blog.common.util;

import com.limyel.blog.common.config.BlogConfig;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptUtil {

    private static BlogConfig.EncryptProperties properties;

    static {
        BlogConfig blogConfig = SpringContextUtil.getBean(BlogConfig.class);
        properties = blogConfig.getEncrypt();
    }

    public static String encrypt(String password) {
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance(properties.getAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("无法检索 pbkdf2_sha256 算法："+e);
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), properties.getSalt().getBytes(StandardCharsets.UTF_8),
                properties.getIteration(), properties.getLength());
        SecretKey secret = null;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("无法生成密钥："+e);
        }
        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.getEncoder().encode(rawHash);

        return new String(hashBase64);
    }

    public static boolean verify(String encryptedPassword, String password) {
        return encryptedPassword.equals(encrypt(password));
    }

    public static String sha256Hex(String text) {
        return DigestUtils.sha256Hex(text);
    }

}
