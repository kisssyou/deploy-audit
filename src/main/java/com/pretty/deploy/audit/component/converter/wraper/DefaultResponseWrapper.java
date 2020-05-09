package com.pretty.deploy.audit.component.converter.wraper;

import com.pretty.deploy.audit.component.exception.ExceptionInfo;
import com.pretty.deploy.audit.entity.JsonDataResult;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 14:07
 */
public class DefaultResponseWrapper implements ResponseWrapper<JsonDataResult> {
    public DefaultResponseWrapper() {
    }

    @Override
    public JsonDataResult wrapData(Object data) {
        JsonDataResult result = new JsonDataResult();
        result.setData(data);
        return result;
    }

    @Override
    public JsonDataResult wrapException(ExceptionInfo exceptionInfo) {
        JsonDataResult jsonResult = new JsonDataResult(exceptionInfo.getCode(), exceptionInfo.getMessage());
        return jsonResult;
    }
}
