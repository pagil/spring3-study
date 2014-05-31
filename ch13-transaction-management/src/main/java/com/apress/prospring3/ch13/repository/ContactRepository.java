package com.apress.prospring3.ch13.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch13.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
