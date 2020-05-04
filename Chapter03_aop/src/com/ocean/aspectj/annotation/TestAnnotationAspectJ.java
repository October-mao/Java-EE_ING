package com.ocean.aspectj.annotation;

import com.ocean.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TestAnnotationAspectJ {
    public static void main(String[] args) {
        //定义一个xml文件
        String xmlPath = "com\\ocean\\aspectj\\annotation\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //1、从spring容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();

    }
}
