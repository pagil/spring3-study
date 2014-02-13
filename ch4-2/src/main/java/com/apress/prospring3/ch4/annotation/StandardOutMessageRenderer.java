package com.apress.prospring3.ch4.annotation;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.apress.prospring3.ch4.MessageProvider;
import com.apress.prospring3.ch4.MessageRenderer;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    //Works this way
    //@Autowired
    @Resource(name="messageProvider")
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    //Works this way
    //@Autowired
    public void setMessageProvider(MessageProvider provider) {
        messageProvider=provider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

}
