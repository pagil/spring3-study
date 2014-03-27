package com.apress.prospring3.ch4.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {

    private Map<String, Object> map;

    private Properties properties;

    private Set set;

    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:xmlBeanFactory.xml");
        ctx.refresh();

        CollectionInjection collectionInjection = (CollectionInjection)ctx.getBean("injectionCollection");
        collectionInjection.displayInfo();

        ctx.close();
    }

    public void displayInfo() {
        System.out.println("\n>>>>>>>>>>>>>>>>>");
        System.out.println("\nMap contents:");
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        System.out.println("\nProperties contents:");
        for (Map.Entry<Object, Object> entry: properties.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        System.out.println("\nSet contents:");
        for (Object o: set) {
            System.out.println("Value: " + o);
        }

        System.out.println("\nList contents:");
        for(Object o: list) {
            System.out.println("Value: " + o);
        }
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

}
