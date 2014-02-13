package com.apress.prospring3.ch4.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:inheritance.xml");
        ctx.refresh();

        SimpleBean parent = (SimpleBean) ctx.getBean("inheritanceParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritanceChild");

        System.out.println("===============\nParent: "+parent);
        System.out.println("===============\nChild: "+child);

        ctx.close();
    }

}
