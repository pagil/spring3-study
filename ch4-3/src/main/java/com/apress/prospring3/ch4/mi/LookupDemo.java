package com.apress.prospring3.ch4.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:lookup.xml");
        ctx.refresh();

        DemoBean abstractBean = (DemoBean)ctx.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean)ctx.getBean("standardLookupBean");

        displayInfo(abstractBean);
        displayInfo(standardBean);

        ctx.close();
    }

    private static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Are hepler instances the same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int i=0; i < 100000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took "+stopWatch.getTotalTimeMillis()+" ms");
    }

}
