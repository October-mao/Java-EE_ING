package com.ocean.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {

    public static void main(String[] args) {
        //配置文件路径
        String XmlPath = "com\\ocean\\assemble\\bean5.xml";
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(XmlPath);
        //构造方式输出结果
        System.out.println(applicationContext.getBean("user1"));
        //设值方式输出结果
        System.out.println(applicationContext.getBean("user2"));
    }
}
