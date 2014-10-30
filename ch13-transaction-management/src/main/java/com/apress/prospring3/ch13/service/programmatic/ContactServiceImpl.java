package com.apress.prospring3.ch13.service.programmatic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.apress.prospring3.ch13.domain.Contact;
import com.apress.prospring3.ch13.service.ContactService;

@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        return null;
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

        final TypedQuery<Long> query = em.createNamedQuery("Contact.countAll", Long.class);

        TransactionCallback<Long> callback = new TransactionCallback<Long>() {
            @Override
            public Long doInTransaction(TransactionStatus arg0) {
                return query.getSingleResult();
            }
        };
        return transactionTemplate.execute(callback);
    }

}
