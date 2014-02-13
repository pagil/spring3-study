package com.apress.prospring3.ch4.xml;

import com.apress.prospring3.ch4.MessageProvider;
import com.apress.prospring3.ch4.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
	
	private MessageProvider messageProvider;

	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You must set the property messageProvider of class:"
					+ StandardOutMessageRenderer.class.getName());
		}
		
		System.out.println(messageProvider.getMessage());
	}

	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

}
