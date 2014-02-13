package com.apress.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {

    private String someValue;

    //@Autowired
    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @Autowired
    public ConstructorConfusion(Integer someValue) {
        System.out.println("ConstructorConfusion(Integer) called");
        this.someValue = "Number: " + someValue;
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + someValue;
    }

    @Override
    public String toString() {
        return someValue;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        ConstructorConfusion constructorConfusion = ctx.getBean("constructorConfusion", ConstructorConfusion.class);
        System.out.println(constructorConfusion);

        constructorConfusion = ctx.getBean("constructorConfusionXML", ConstructorConfusion.class);
        System.out.println(constructorConfusion);

        ctx.close();
    }

}
