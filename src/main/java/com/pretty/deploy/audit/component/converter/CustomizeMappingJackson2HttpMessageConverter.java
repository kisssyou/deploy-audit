package com.pretty.deploy.audit.component.converter;

import com.pretty.deploy.audit.component.converter.wraper.ResponseWrapper;
import com.pretty.deploy.audit.component.exception.ExceptionInfo;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 11:04
 */
public class CustomizeMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    private ResponseWrapper responseWrapper;

    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (this.responseWrapper != null) {
            if (object instanceof ExceptionInfo) {
                ExceptionInfo exceptionInfo = (ExceptionInfo)object;
                object = this.responseWrapper.wrapException(exceptionInfo);
            } else {
                object = this.responseWrapper.wrapData(object);
            }
        }

        super.writeInternal(object, type, outputMessage);
    }

    public void setResponseWrapper(ResponseWrapper responseWrapper) {
        this.responseWrapper = responseWrapper;
    }
}
