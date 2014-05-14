package com.apress.prospring3.ch10.service;

import java.util.List;

import com.apress.prospring3.ch10.domain.ContactSummary;

public interface ContactSummaryService {

    public List<ContactSummary> findAll();
}
