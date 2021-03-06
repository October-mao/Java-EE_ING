package com.ocean.jdk;

import com.ocean.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk的代理类
 */
public class JdkProxy implements InvocationHandler {

    //声明目标类接口
    private UserDao userDao;
    //创建代理方法
    public Object createProxy(UserDao userDao){
        this.userDao=userDao;
        //1.类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        //2.被代理对象实现的所有接口
        Class<?>[] clazz = userDao.getClass().getInterfaces();
        //3.使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader,clazz,this);

    }

    /**
     * 所有动态代理类的方法调用，都会交由invoke()方法去处理
     * @param o 被代理后的对象
     * @param method 将要被执行的方法信息(反射过来的)
     * @param objects  执行方法时需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //声明切面
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_Permission();
        //在目标类上调用方法并传入参数
        Object obj = method.invoke(userDao,objects);
        //后增强
        myAspect.log();
        return obj;
    }
}
