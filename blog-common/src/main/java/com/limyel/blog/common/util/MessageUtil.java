package com.limyel.blog.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class MessageUtil {

    private static MessageSource messageSource;

    static {
        messageSource = (MessageSource)SpringContextUtil.getBean("messageSource");
    }

    public static String getMessage(int code) {
        return getMessage(code);
    }

    public static String getMessage(int code, String... params) {
        return messageSource.getMessage(code + "", params, LocaleContextHolder.getLocale());
    }

}
