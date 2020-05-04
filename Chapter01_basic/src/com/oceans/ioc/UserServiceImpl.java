package com.oceans.ioc;

public class UserServiceImpl implements UserService{
    //声明userDao
    private UserDao userDao;
    //添加UserDao属性的setter方法，实现依赖注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //
    @Override
    public void say() {
        //调用UserDao中的say
        userDao.say();
        System.out.println("UserService say hello world!!!");
    }
}
