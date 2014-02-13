package com.apress.prospring3.ch5.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanJSR250 {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name = null;

    private int age = Integer.MIN_VALUE;

    @Override
    public String toString() {
        return "SimpleBeanJSR250 [name=" + name + ", age=" + age + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void myInitializationProcedure() throws Exception {
        System.out.println("Initializing bean in myInitializationProcedure()");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type "
                    + SimpleBeanJSR250.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/initJSR250.xml");
        ctx.refresh();

        SimpleBeanJSR250 simpleBean1 = (SimpleBeanJSR250) ctx.getBean("simpleBean1");
        System.out.println(simpleBean1);
        SimpleBeanJSR250 simpleBean2 = (SimpleBeanJSR250) ctx.getBean("simpleBean2");
        System.out.println(simpleBean2);
        SimpleBeanJSR250 simpleBean3 = (SimpleBeanJSR250) ctx.getBean("simpleBean3");
        System.out.println(simpleBean3);

        ctx.close();
    }

}
