package com.ocean.annotation;

import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao......Save...");
    }
}
