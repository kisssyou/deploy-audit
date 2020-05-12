package com.pretty.deploy.audit.utils;

import com.pretty.deploy.audit.component.exception.BusinessException;

/**
 * @Author:Tanht
 * @Description:
 * @Date:5:43 PM 5/9/2020
 */


public class Asserts {

    public static void isNull(Object o, String code){
        if (o == null){
            throw new BusinessException(code);
        }
    }

    public static void isNotEquals(String currentStr,String str,String code){
        if(!currentStr.equals(str)){
            throw new BusinessException(code);
        }
    }

}
