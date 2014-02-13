package com.apress.prospring3.ch5.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;

        if (ctx instanceof GenericApplicationContext) {
            ((GenericApplicationContext)ctx).registerShutdownHook();
        }
    }

}
