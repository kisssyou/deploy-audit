package com.pretty.deploy.audit.component.exception;

import lombok.Data;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 13:56
 */
@Data
public class ExceptionInfo {
    private String code;
    private String message;
    private Object extend;
}
