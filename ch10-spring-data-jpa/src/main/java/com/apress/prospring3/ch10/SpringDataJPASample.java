package com.apress.prospring3.ch10;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.service.ContactService;

public class SpringDataJPASample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

        // Find all contacts
        List<Contact> contacts = contactService.findAll();
        listContacts(contacts);

        // Find contacts by first name
        contacts = contactService.findByFirstName("Migel");
        listContacts(contacts);

        // Find contacts by first name and last name
        contacts = contactService.findByFistrNameAndLastName("Clarence", "Ho");
        listContacts(contacts);

        ctx.close();
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println();
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
