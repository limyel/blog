package com.limyel.blog.common.util;

import com.limyel.blog.BlogApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BlogApplication.class)
public class EncryptUtilTest {

    @Test
    public void testEncrypt() {
        System.out.println(EncryptUtil.encrypt("123456"));
    }

}
