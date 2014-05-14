package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.Contact;

public interface ContactService {

    // Find all contacts
    public List<Contact> findAll();

    // Find contacts by first name
    public List<Contact> findByFirstName(String firstName);

    // Find contacts by first name and last name
    public List<Contact> findByFistrNameAndLastName(String firstName, String lastName);

}
