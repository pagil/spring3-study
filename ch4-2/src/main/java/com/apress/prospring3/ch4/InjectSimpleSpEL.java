package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch4.xml.InjectSimple;

public class InjectSimpleSpEL {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();

        InjectSimple injectSimple = (InjectSimple)ctx.getBean("injectSimpleSpEL");
        System.out.println(injectSimple);

        ctx.close();

        ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        com.apress.prospring3.ch4.annotation.InjectSimpleSpEL injectSimpleSpEl =
                (com.apress.prospring3.ch4.annotation.InjectSimpleSpEL)ctx.getBean("injectSimpleSpEL");
        System.out.println(injectSimpleSpEl);

        ctx.close();
    }

}
