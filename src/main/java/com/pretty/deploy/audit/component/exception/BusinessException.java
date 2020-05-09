package com.pretty.deploy.audit.component.exception;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 11:15
 */
public class BusinessException extends ServiceException {
    public BusinessException(String errorCode) {
        super(errorCode);
    }

    public BusinessException(String errorCode, Object... args) {
        super(errorCode, args);
    }

    public BusinessException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BusinessException(String errorCode, Throwable cause, Object[] args) {
        super(errorCode, cause, args);
    }
}
