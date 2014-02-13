package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingSetterInjectionAnnotation {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-annotation.xml");
		ctx.refresh();
		
		MessageRenderer messageRemderer = ctx.getBean("messageRenderer",
				MessageRenderer.class);
		messageRemderer.render();
		
		ctx.close();
	}

}
