package com.apress.prospring3.ch5.lifecycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    private InputStream is = null;

    private String filePath = null;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializing bean");

        if (filePath == null) {
            throw new IllegalArgumentException("");
        }

        is = new FileInputStream(filePath);
    }

    public void destroy() throws Exception {
        System.out.println("Destrouyng bean");

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
        ctx.load("classpath:lifecycle/disposeInterface.xml");
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");

        System.out.println("Calling destroySingletons()");
        ctx.destroy();
        System.out.println("Called destroySingletons()");
        ctx.close();
    }

}
