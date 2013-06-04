package com.apress.prospring3.ch4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class XmlConfigWithBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        FileSystemResource resource = new FileSystemResource("src/main/resources/xmlBeanFactory.xml");

        reader.loadBeanDefinitions(resource);

        Oracle oracle = (Oracle)factory.getBean("oracle");

        // New comment was added
        System.out.println(oracle.defineMeaningOfLife());

    }

}
