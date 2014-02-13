package com.apress.prospring3.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithJSR250 {

    private InputStream is = null;
    private String filePath = null;

    public void setFilePath(String filePath) {
        System.out.println("Setting property filePath = " + filePath);
        this.filePath = filePath;
    }

    @PostConstruct
    public void intializationMethod() throws FileNotFoundException {
        System.out.println("Initializing Bean intializationMethod()");
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBean.class);
        }
        is = new FileInputStream(filePath);
    }

    @PreDestroy
    public void destructionMethod() {
        System.out.println("Destroying Bean destructionMethod()");
        if (is != null) {
            try {
                is.close();
                is = null;
            } catch (IOException ex) {
                System.err.println("WARN: An IOException occured"
                        + " trying to close the InputStream");
            }
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/disposeJSR250.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");

        /*System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
        ctx.close();*/

    }

}
