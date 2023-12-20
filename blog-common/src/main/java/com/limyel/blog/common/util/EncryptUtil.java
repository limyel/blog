package com.limyel.blog.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class EncryptUtil {

    public static String getSalt() {
        return RandomStringUtils.randomAlphabetic(64);
    }

    public static String encrypt(String password) {
        return DigestUtils.sha256Hex(password);
    }

    public static String encrypt(String password, String salt) {
        return encrypt(password + salt);
    }

    public static boolean verify(String encryptedPassword, String password) {
        password = encrypt(password);
        return password.equals(encryptedPassword);
    }

}
