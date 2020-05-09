package com.pretty.deploy.audit.component.converter.wraper;

import com.pretty.deploy.audit.component.exception.ExceptionInfo;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 14:06
 */
public interface ResponseWrapper<T> {
    T wrapData(Object var1);

    T wrapException(ExceptionInfo var1);
}
