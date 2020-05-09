package com.pretty.deploy.audit.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author haoxm
 * @description: 获取当前国际化的翻译值
 * @date 2020/5/9 11:28
 */
@Slf4j
@Component
public class MessageUtils {

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey) {
        try {
            MessageSource messageSource = SpringContextHolder.getBean(MessageSource.class);
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            log.error("获取配置异常", e);
            return msgKey;
        }
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey, Object... args) {
        try {
            MessageSource messageSource = SpringContextHolder.getBean(MessageSource.class);
            return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            log.error("获取配置异常", e);
            return msgKey;
        }
    }

}
