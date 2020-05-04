package com.ocean.instance.static_factory;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {
    public static void main(String[] args) {
        //配置xml文件位置
        String xmlPath = "com\\ocean\\instance\\static_factory\\beans2.xml";
//        ApplicationContext 在加载配置文件，对Bean实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean2"));
    }
}
