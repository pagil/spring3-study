package com.apress.prospring3.ch10.service.springjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch10.domain.ContactAudit;
import com.apress.prospring3.ch10.repository.ContactAuditRepository;
import com.apress.prospring3.ch10.service.ContactAuditService;
import com.google.common.collect.Lists;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public ContactAudit save(ContactAudit contactAudit) {
        return contactAuditRepository.save(contactAudit);
    }

    @Transactional(readOnly = true)
    @Override
    public ContactAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(ContactAudit.class, id, revision);
    }

}
