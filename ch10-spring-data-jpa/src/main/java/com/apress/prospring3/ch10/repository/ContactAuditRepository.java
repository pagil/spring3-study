package com.apress.prospring3.ch10.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch10.domain.ContactAudit;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}
