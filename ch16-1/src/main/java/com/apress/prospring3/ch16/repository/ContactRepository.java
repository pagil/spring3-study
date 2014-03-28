package com.apress.prospring3.ch16.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch16.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    public List<Contact> findByFirstName(String firstName);
}
