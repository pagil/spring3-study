package com.apress.prospring3.ch13;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

public class TxAnnotationSample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/tx-annotation-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        List<Contact> contacts = contactService.findAll();

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        ctx.close();
    }

}
