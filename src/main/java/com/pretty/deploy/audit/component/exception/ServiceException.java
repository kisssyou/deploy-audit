package com.pretty.deploy.audit.component.exception;

import com.pretty.deploy.audit.utils.MessageUtils;
import com.pretty.deploy.audit.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 11:12
 */
public class ServiceException extends RuntimeException{

    protected MessageSource messageSource;

    private static final long serialVersionUID = -2676828235770385776L;
    private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeException.class);
    protected String errorCode;
    protected Object[] args;
    protected Object extend;

    public ServiceException(String errorCode) {
        this.errorCode = errorCode;
        LOGGER.error("Internal Server Error,error code[{}]", errorCode);
    }

    public ServiceException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = (Object[])args.clone();
        LOGGER.error("Internal Server Error,error code[{}] message[{}]", errorCode, MessageUtils.get(errorCode, args));
    }

    public ServiceException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        LOGGER.error("Internal Server Error,error code[{}] message[{}]", new Object[]{errorCode, cause.getMessage()});
    }

    public ServiceException(String errorCode, Throwable cause, Object[] args) {
        super(cause);
        this.errorCode = errorCode;
        this.args = (Object[])args.clone();
        this.messageSource = (MessageSource) SpringContextHolder.getBean(MessageSource.class);
        LOGGER.error("Internal Server Error,error code[{}] message[{}] exception info[{}]", new Object[]{errorCode, this.messageSource.getMessage(errorCode, args, LocaleContextHolder.getLocale()), cause.getMessage()});
    }

    @Override
    public String getMessage() {
        return this.getMessage(LocaleContextHolder.getLocale());
    }

    public String getMessage(Locale locale) {
        this.messageSource = (MessageSource) SpringContextHolder.getBean(MessageSource.class);
        return this.messageSource.getMessage(this.errorCode, this.args, locale);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public ServiceException setExtend(Object extend) {
        this.extend = extend;
        return this;
    }

    public Object getExtend() {
        return this.extend;
    }
}
