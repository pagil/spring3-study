package com.apress.prospring3.ch13.service.declarative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.repository.ContactRepository;
import com.apress.prospring3.ch13.service.ContactService;
import com.google.common.collect.Lists;

/**
 * @Transactional annotations were removed, because now the weaving of transactions will be done by Spring AOP based on
 *                the XML configuration
 * 
 * @author Victor
 * 
 */
@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public long countAll() {
        return contactRepository.count();
    }

}
