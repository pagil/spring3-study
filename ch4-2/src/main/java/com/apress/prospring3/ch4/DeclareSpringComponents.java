package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:app-context-xml.xml");//Produces: Hello world XML! 
		//context.load("classpath:app-context-annotation.xml");//Produces: Hello world Annotation!
		context.refresh();
		
		MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
		
		System.out.println(messageProvider.getMessage());

	}

}
