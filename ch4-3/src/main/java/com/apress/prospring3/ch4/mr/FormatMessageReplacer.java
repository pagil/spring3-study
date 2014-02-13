package com.apress.prospring3.ch4.mr;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if(isFormatMessageMethod(method)){
            String msg = args[0].toString();
            return "<h2>"+msg+"<h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }

        if (method.getParameterTypes().length != 1) {
            return false;
        }

        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }

        if (method.getReturnType() != String.class) {
            return false;
        }

        return true;
    }

}
