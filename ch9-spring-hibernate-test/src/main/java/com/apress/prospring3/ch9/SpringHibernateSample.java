package com.apress.prospring3.ch9;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch9.dao.ContactDao;
import com.apress.prospring3.ch9.domain.Contact;
import com.apress.prospring3.ch9.domain.ContactTelDetail;
import com.apress.prospring3.ch9.domain.Hobby;

public class SpringHibernateSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAllWithDetail();
        listContacts(contacts);

        System.out.println();
        Contact contact = contactDao.findById(1L);
        System.out.println("Contact with id = 1: " + contact);

        // Add new contact
        contact = new Contact();
        contact.setFirstName("Michae4");
        contact.setLastName("Jackson4");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Work", "333333333333");
        contact.addContactTelDetail(contactTelDetail);
        contactDao.save(contact);
        contacts = contactDao.findAllWithDetail();
        listContacts(contacts);

        // Edit existing contact
        contact = contactDao.findById(7L);
        contact.setFirstName("Kin Fung");
        Set<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
        ContactTelDetail toDeleteContcatTelDetail = null;
        for (ContactTelDetail contactTel : contactTelDetails) {
            if ("Home".equals(contactTel.getTelType())) {
                toDeleteContcatTelDetail = contactTel;
            }
        }
        contact.removeContatTelDetail(toDeleteContcatTelDetail);
        contactDao.save(contact);
        contacts = contactDao.findAllWithDetail();
        listContacts(contacts);

        // Delete contact
        contact = contactDao.findById(6L);
        contactDao.delete(contact);
        contacts = contactDao.findAllWithDetail();
        listContacts(contacts);
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println("\n" + contact);
            for (ContactTelDetail contactTelDetails : contact.getContactTelDetails()) {
                System.out.println("\t" + contactTelDetails);
            }
            System.out.println();
            for (Hobby hobby : contact.getHobbies()) {
                System.out.println("\t" + hobby);
            }
        }
    }
}
