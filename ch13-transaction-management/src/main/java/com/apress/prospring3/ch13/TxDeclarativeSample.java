package com.apress.prospring3.ch13;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

public class TxDeclarativeSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/tx-declarative-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);

        // Testing findAll() method
        List<Contact> contacts = contactService.findAll();
        System.out.println(">>>>>>>>>>>>> Contacts List: >>>>>>>>>>>>>>>>>");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        // Testing save() method
        Contact contact = contactService.findById(1L);
        contact.setFirstName("Adam");
        contactService.save(contact);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Contact saved succesfully");

        // Testing countAll() method
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Contact count: " + contactService.countAll());

        ctx.close();
    }

}
