package com.apress.prospring3.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch4.Oracle;

public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:xmlBeanFactory.xml");
        ctx.refresh();

        InjectRef injectRef = (InjectRef)ctx.getBean("injectRef");
        System.out.println(injectRef);

        ctx.close();

    }

}
