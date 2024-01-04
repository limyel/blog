package com.limyel.blog.common.util;

import com.limyel.blog.common.config.BlogConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtil {

    private static BlogConfig.RsaProperties rsa;

    static {
        BlogConfig blogConfig = SpringContextUtil.getBean(BlogConfig.class);
        rsa = blogConfig.getRsa();
    }

    public static PublicKey getPublicKey() {
        try {
            ClassPathResource resource = new ClassPathResource(rsa.getPub());
            byte[] publicKeyBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            byte[] decode = Base64Utils.decode(publicKeyBytes);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decode);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        } catch (IOException e) {
            throw new SecurityException("加载公钥文件失败！", e);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new SecurityException(e.getMessage(), e);
        }
    }

    public static PrivateKey getPrivateKey() {
        try {
            ClassPathResource resource = new ClassPathResource(rsa.getPub());
            byte[] privateKeyBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            byte[] decode = Base64Utils.decode(privateKeyBytes);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decode);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        } catch (IOException e) {
            throw new SecurityException("加载私钥文件失败！", e);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new SecurityException(e.getMessage(), e);
        }
    }

}
