package com.pretty.deploy.audit.config;

import com.pretty.deploy.audit.component.converter.CustomizeMappingJackson2HttpMessageConverter;
import com.pretty.deploy.audit.component.converter.wraper.DefaultResponseWrapper;
import com.pretty.deploy.audit.component.converter.wraper.ResponseWrapper;
import com.pretty.deploy.audit.entity.JsonDataResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 14:41
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    /**
     * 国际化文件解析配置
     * @return
     */
    @Bean(name = {"messageSource"})
    public ResourceBundleMessageSource getMessageResource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames(new String[]{"i18n/messages"});
        return messageSource;
    }

    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.CHINA);
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        registry.addInterceptor(localeInterceptor);
    }

    @Bean
    public CustomizeMappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);

        CustomizeMappingJackson2HttpMessageConverter messageConverter = new CustomizeMappingJackson2HttpMessageConverter();
        messageConverter.setResponseWrapper(getResponseWrapper());
        return messageConverter;
    }

    @Bean("ResponseWrapper")
    public ResponseWrapper<JsonDataResult> getResponseWrapper() {
        return new DefaultResponseWrapper();
    }
}
