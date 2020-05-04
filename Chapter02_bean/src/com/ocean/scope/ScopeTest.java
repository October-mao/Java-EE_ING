package com.ocean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        //定义配置文件路径
        String xmlPath = "com\\ocean\\scope\\beans4.xml";
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //输出获得的实例
        System.out.println(applicationContext.getBean("bean4"));
        System.out.println(applicationContext.getBean("bean4"));
    }
}
