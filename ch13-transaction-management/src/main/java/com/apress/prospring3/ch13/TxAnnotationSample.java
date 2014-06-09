package com.apress.prospring3.ch13;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.service.ContactService;

public class TxAnnotationSample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/tx-annotation-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        // List<Contact> contacts = contactService.findAll();
        //
        // System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // for (Contact contact : contacts) {
        // System.out.println(contact);
        // }
        // System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        //
        // Contact contact = contactService.findById(1L);
        // contact.setFirstName("Peter");
        // contactService.save(contact);
        // System.out.println("Contact saved succesfully");

        System.out.println("Contacts count: " + contactService.countAll());

        ctx.close();
    }

}
