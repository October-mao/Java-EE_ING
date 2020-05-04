package com.ocean.instance.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {
    public static void main(String[] args) {
        //指定配置文件路径
        String xmlPath = "com\\ocean\\instance\\factory\\beans3.xml";
        //ApplicationContext在加载配置文件时，对bean实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean3"));
    }
}
