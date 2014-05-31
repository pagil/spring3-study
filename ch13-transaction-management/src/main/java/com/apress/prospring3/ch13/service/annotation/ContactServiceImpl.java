package com.apress.prospring3.ch13.service.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.repository.ContactRepository;
import com.apress.prospring3.ch13.service.ContactService;
import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    public Contact findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long countAll() {
        // TODO Auto-generated method stub
        return 0;
    }

}
