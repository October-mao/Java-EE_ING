package com.ocean.annotation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userService...save...");
    }
}
