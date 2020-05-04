package com.ocean.cglib;

import com.ocean.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    //代理方法
    public Object createProxy(Object target){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //添加回调函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }
    /**
     *
     * @param o  Cglib根据指定父类生成的代理对象
     * @param method 拦截的方法
     * @param objects 拦截方法的参数
     * @param methodProxy 方法的代理对象，用于执行父类的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //创建切面对象
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_Permission();
        //目标方法的执行
        Object object = methodProxy.invokeSuper(o,objects);
        //后增强
        myAspect.log();
        return object;
    }
}
