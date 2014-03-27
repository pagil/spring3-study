package com.apress.prospring3.ch4.annotation;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("collectionInjection")
public class CollectionInjection {

    @Resource(name="map")
    private Map<String, Object> map;

    @Resource(name="props")
    private Properties properties;

    @Resource(name="set")
    private Set set;

    @Resource(name="list")
    private List list;

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        CollectionInjection collectionInjection = (CollectionInjection)ctx.getBean("collectionInjection");
        System.out.println(collectionInjection);

        ctx.close();
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

    @Override
    public String toString() {
        return "CollectionInjection \n[map=" + map + ",\n properties=" + properties
                + ",\n set=" + set + ",\n list=" + list
                + "]";
    }


}
