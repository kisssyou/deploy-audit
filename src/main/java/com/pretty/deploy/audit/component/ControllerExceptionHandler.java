package com.pretty.deploy.audit.component;

import com.pretty.deploy.audit.component.exception.ExceptionInfo;
import com.pretty.deploy.audit.component.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haoxm
 * @description: 全局异常处理
 * @date 2020/5/9 13:57
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ExceptionInfo runtimeExceptionHandler(Exception e){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        String code = "", message = "";
        if (e instanceof ServiceException){
            code = ((ServiceException) e).getErrorCode();
            message = e.getMessage();
        }else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            code = "9000";
            message = this.messageSource.getMessage(code, new String[]{bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage()}, LocaleContextHolder.getLocale());
        }else if (MethodArgumentNotValidException.class.equals(e.getClass())) {
            code = "9000";
            message = this.messageSource.getMessage(code, (Object[])null, LocaleContextHolder.getLocale());
        }else {
            code = "9999";
            message = this.messageSource.getMessage(code, (Object[])null, LocaleContextHolder.getLocale());
            log.info("class: {}", e.getClass());
            log.error("服务端错误", e);
        }
        exceptionInfo.setCode(code);
        exceptionInfo.setMessage(message);
        return exceptionInfo;
    }

}


