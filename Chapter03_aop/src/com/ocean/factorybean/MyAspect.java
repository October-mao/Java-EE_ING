package com.ocean.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//切面类
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //前增强
        check_Permissions();
        //执行目标方法
        Object obj = methodInvocation.proceed();
        //后增强
        log();
        return null;
    }

    public void check_Permissions() {
        System.out.println("模拟检查权限");
    }
    public void log(){
        System.out.println("模拟检查日志");
    }
}
