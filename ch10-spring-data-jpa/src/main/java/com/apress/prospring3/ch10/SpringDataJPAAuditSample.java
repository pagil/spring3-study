package com.apress.prospring3.ch10;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch10.domain.ContactAudit;
import com.apress.prospring3.ch10.service.ContactAuditService;

public class SpringDataJPAAuditSample {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactAuditService contactService = ctx.getBean("contactAuditService", ContactAuditService.class);

        List<ContactAudit> contacts = contactService.findAll();
        listContactAudit(contacts);

        // Add new contact
        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("John");
        contact.setLastName("Deer");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContactAudit(contacts);
        System.out.println("====================================");

        // Find by id
        contact = contactService.findById(4L);
        System.out.println("Contact with id 4: " + contact);
        System.out.println("====================================");

        // Update contact
        System.out.println("Update contact");
        contact.setFirstName("Bill");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContactAudit(contacts);
        System.out.println("====================================");

        // Find audit record by revision
        ContactAudit oldContact = contactService.findAuditByRevision(4L, 5);
        System.out.println("Old contact with id 1 and rev 1:" + oldContact);
        System.out.println("====================================");
        oldContact = contactService.findAuditByRevision(4L, 6);
        System.out.println("Old contact with id 1 and rev 2:" + oldContact);
        System.out.println("====================================");

        ctx.close();
    }

    private static void listContactAudit(List<ContactAudit> contacts) {
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
        }
    }

}
