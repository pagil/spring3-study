package com.apress.prospring3.ch10.service.springjpa.auditor;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "prospring3";
    }

}
