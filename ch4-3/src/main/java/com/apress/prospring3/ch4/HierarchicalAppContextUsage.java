package com.apress.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

    public static void main(String[] args) {

        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:parent.xml");
        parent.refresh();

        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:child.xml");
        // !!!!!!
        child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = (SimpleTarget)child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget)child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget)child.getBean("target3");
        SimpleTarget target4 = (SimpleTarget)child.getBean("target4");

        System.out.printf("%-25s %s\n", "bean=injectBeanParent : ", target1.getValue());
        System.out.printf("%-25s %s\n", "bean=injectBean : ", target2.getValue());
        System.out.printf("%-25s %s\n", "parent=injectBean : ", target3.getValue());
        System.out.printf("%-25s %s\n", "local=injectBean : ", target4.getValue());

        parent.close();
        child.close();
    }

}
