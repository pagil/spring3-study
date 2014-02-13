package com.apress.prospring3.ch4.annotation;

import org.springframework.stereotype.Service;

import com.apress.prospring3.ch4.MessageProvider;

//@Service("messageProvider")
@Service("messageProvider1")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hello world Annotation!";
	}

}
