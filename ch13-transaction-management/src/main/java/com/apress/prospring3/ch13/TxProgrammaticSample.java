package com.apress.prospring3.ch13;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.service.ContactService;

public class TxProgrammaticSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/tx-programmatic-app-context.xml");
        ctx.refresh();

        ContactService contactsService = ctx.getBean("contactService", ContactService.class);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Count countacts: " + contactsService.countAll());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        ctx.close();
    }
}
