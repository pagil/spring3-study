package com.apress.prospring3.ch13.service;

import java.util.List;

import com.apress.prospring3.ch13.domain.Contact;

public interface ContactService {

    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    long countAll();
}
