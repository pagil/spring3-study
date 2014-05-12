package com.apress.prospring3.ch10;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.domain.ContactTelDetail;
import com.apress.prospring3.ch10.domain.Hobby;
import com.apress.prospring3.ch10.service.ContactService;

public class JpaSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

        // Add new contact
        Contact contact = new Contact();
        contact.setFirstName("Max");
        contact.setLastName("Anderson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "11111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "3333333333333");
        contact.addContactTelDetail(contactTelDetail);
        contactService.save(contact);
        // List contacts without details
        List<Contact> contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);

        System.out.println();

        contact = contactService.findById(1L);
        System.out.println(contact);

        // Find contact by ID
        contact = contactService.findById(1L);
        System.out.println();
        System.out.println("Contact with id1: " + contact);
        System.out.println();

        // Update contact
        contact.setFirstName("Kim Fing");
        Set<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
        ContactTelDetail toDeleteContactTelDetail = null;
        for (ContactTelDetail contactTel : contactTelDetails) {
            if ("Home".equals(contactTel.getTelType())) {
                toDeleteContactTelDetail = contactTel;
            }
        }
        contactTelDetails.remove(toDeleteContactTelDetail);
        contactService.save(contact);
        contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println();
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("\t" + contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println("\t" + hobby);
                }
            }
        }
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println();
        System.out.println("Listing contcats without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
