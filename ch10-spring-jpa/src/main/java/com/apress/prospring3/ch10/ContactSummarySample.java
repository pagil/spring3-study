package com.apress.prospring3.ch10;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch10.service.jpa.ContactSummaryUntypeImpl;

public class ContactSummarySample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        // Contact summary with untype result
        ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype",
                ContactSummaryUntypeImpl.class);
        contactSummaryUntype.displayAllContactSummary();
    }

}
