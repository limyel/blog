package com.limyel.blog.common.util;

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

    private static String salt;
    private static String SALT_KEY = "${haoyuan.password.salt:123456}";

    private static Integer iteration;
    private static String ITERATION_KEY = "${haoyuan.password.iteration:1000}";

    private static Integer length;
    private static String LENGTH_KEY = "${haoyuan.password.length:512}";

    //算法名称
    private static final String ALGORITHM_NAME = "PBKDF2WithHmacSHA256";

    static {
        salt = SpringContextUtil.getProperty(SALT_KEY);
        iteration = Integer.valueOf(SpringContextUtil.getProperty(ITERATION_KEY));
        length = Integer.valueOf(SpringContextUtil.getProperty(LENGTH_KEY));
    }

    public static String encrypt(String password) {
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance(ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("无法检索 pbkdf2_sha256 算法："+e);
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), iteration, length);
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
