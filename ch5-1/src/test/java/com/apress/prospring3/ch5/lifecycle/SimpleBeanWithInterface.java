package com.apress.prospring3.ch5.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface implements InitializingBean {


    private static final String DEFAULT_NAME = "Luke Skewalker";

    private String name = null;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBeanWithInterface [name=" + name + ", age=" + age + "]";
    }

    public void myInit() {
        System.out.println("My Init");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean in afterPropertiesSet()");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type "
                    + SimpleBeanWithInterface.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lifecycle/initInterface.xml");
        ctx.refresh();

        SimpleBeanWithInterface simpleBean1 = (SimpleBeanWithInterface) ctx.getBean("simpleBean1");
        System.out.println(simpleBean1);
        SimpleBeanWithInterface simpleBean2 = (SimpleBeanWithInterface) ctx.getBean("simpleBean2");
        System.out.println(simpleBean2);
        SimpleBeanWithInterface simpleBean3 = (SimpleBeanWithInterface) ctx.getBean("simpleBean3");
        System.out.println(simpleBean3);

        ctx.close();
    }

}
