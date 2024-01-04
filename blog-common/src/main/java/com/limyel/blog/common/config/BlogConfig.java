package com.limyel.blog.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "blog")
public class BlogConfig {

    private EncryptProperties encrypt = new EncryptProperties();

    @Getter
    @Setter
    public static class EncryptProperties {
        private String salt = "123456";
        private Integer iteration = 100;
        private Integer length = 512;
        private String algorithm = "PBKDF2WithHmacSHA256";
    }

}
