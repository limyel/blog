package com.limyel.blog.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class RsaGenerateUtil {

    public static final int DEFAULT_KEY_SIZE = 2048;
    public static final String RSA_SECURT = "websecurity";

    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String secret) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom(secret.getBytes());
            keyPairGenerator.initialize(DEFAULT_KEY_SIZE, secureRandom);
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // 获取公钥并写出
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
            publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
            writeFile(publicKeyFilename, publicKeyBytes);

            // 获取私钥并写出
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
            privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
            writeFile(privateKeyFilename, privateKeyBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException(e.getMessage(), e);
        }
    }

    private static void writeFile(String filename, byte[] bytes) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(file.toPath(), bytes);
        } catch (IOException e) {
            throw new SecurityException("保存密钥文件失败！", e);
        }
    }

    public static void main(String[] args) {
        generateKey("/tmp/jwt_rsa.pub", "/tmp/jwt_rsa", RSA_SECURT);
    }

}
