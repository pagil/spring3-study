package com.apress.prospring3.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean {

    private InputStream is = null;

    private String filePath = null;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean afterPropertiesSet()");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of the "+
                    DestructiveBean.class);
        }

        is = new FileInputStream(filePath);
    }

    public void destroy() {
        System.out.println("Destroy bean destroy()");

        if (is != null) {
            try {
                is.close();
                is = null;
            } catch (IOException ex) {
                System.err.println("WARN: An IOException occured trying to close the InputStream");
            }
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/disposeMethod.xml");
        ctx.refresh();

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");

        System.out.println("Calling destroy");
        ctx.destroy();
        System.out.println("Called destroy");
        ctx.close();
        ctx.close();
    }

}
