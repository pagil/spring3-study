package com.apress.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {

    @Value("John Smith")
    private String name;

    @Value("35")
    private int age;

    @Value("1.78")
    private float height;

    @Value("1")
    private boolean programmer;

    @Value("1103760000")
    private Long ageInSeconds;

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        InjectSimple injectSimple = (InjectSimple)ctx.getBean("injectSimple");
        System.out.println(injectSimple);

        ctx.close();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple annotation \n"
                + " [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
                + ", ageInSeconds=" + ageInSeconds + "]";
    }


}
