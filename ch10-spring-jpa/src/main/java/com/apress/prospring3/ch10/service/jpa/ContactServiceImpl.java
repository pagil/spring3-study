package com.apress.prospring3.ch10.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch10.domain.Contact;
import com.apress.prospring3.ch10.service.ContactService;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    private Log log = LogFactory.getLog(ContactServiceImpl.class);

    final static String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birthdate, version from contact";

    @PersistenceContext(name = "emf")
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        List<Contact> contcats = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contcats;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAllWithDetail() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
        return contacts;
    }

    @Override
    public Contact findById(Long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            // Insert Contact
            log.info("Inserting new contact");
            em.persist(contact);
        } else {
            // Update Contact
            em.merge(contact);
            log.info("Updating existing contact");
        }
        log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        // This is essential, because you need to get managed contact entity instance.
        Contact mergeContact = em.merge(contact);
        em.remove(mergeContact);
        // If you make this simply like that:
        // em.remove(contact);
        // You will get exception: java.lang.IllegalArgumentException: Removing a detached instance
        // com.apress.prospring3.ch10.domain.Contact#10
        log.info("Contact with id: " + contact.getId() + " deleted succesfully");
    }

}
