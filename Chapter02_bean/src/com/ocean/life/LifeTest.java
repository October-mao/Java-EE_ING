package com.ocean.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    public static void main(String[] args) {
        String xmlPath = "com\\ocean\\life\\life.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        context.close();

    }
}
