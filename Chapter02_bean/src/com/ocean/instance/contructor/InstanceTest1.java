package com.ocean.instance.contructor;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
    public static void main(String[] args) {
        //定义xml文件位置
        String xmlPath = "com\\ocean\\instance\\contructor\\beans1.xml";
//        ApplicationContext 在加载配置文件时，对Bean进行实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println(bean1);
    }
}
