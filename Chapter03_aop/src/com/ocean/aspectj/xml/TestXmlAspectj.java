package com.ocean.aspectj.xml;

import com.ocean.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAspectj {
    public static void main(String[] args) {
        String xmlPath = "com\\ocean\\aspectj\\xml\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //1、从Spring容器中获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //2、执行方法
        userDao.addUser();
    }
}
