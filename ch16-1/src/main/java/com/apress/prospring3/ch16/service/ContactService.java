package com.apress.prospring3.ch16.service;

import java.util.List;

import com.apress.prospring3.ch16.domain.Contact;

public interface ContactService {

    public List<Contact> findAll();

    public List<Contact> findByFirstName(String firstName);

    public Contact findById(Long id);

    public Contact save(Contact contact);

    public void delete(Contact contact);

}
