package com.apress.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBeanExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:interaction/shutdownHook.xml");
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface)ctx.getBean("destructiveBean");

    }

}
