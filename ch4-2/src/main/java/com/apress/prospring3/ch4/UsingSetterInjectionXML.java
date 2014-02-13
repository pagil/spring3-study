package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingSetterInjectionXML {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-xml.xml");
		ctx.refresh();
		MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
				MessageRenderer.class);
		messageRenderer.render();

		MessageRenderer messageRenderer1 = ctx.getBean("messageRenderer1",
				MessageRenderer.class);
		messageRenderer1.render();
		
		ctx.close();
	}

}
