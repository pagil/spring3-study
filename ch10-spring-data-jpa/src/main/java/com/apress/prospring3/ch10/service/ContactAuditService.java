package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.ContactAudit;

public interface ContactAuditService {

    List<ContactAudit> findAll();

    ContactAudit findById(Long id);

    ContactAudit save(ContactAudit contactAudit);

    ContactAudit findAuditByRevision(Long id, int revision);
}
