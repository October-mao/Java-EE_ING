package com.ocean.assemble;

import java.util.List;

public class User {
    private String username;
    private Integer password;
    private List<String> list;
    /*
        2.使用设值注入
       2.1提供默认空参数构造
       2.2为所有属性提供setter方法
     */
    public User() {
    }

    public User(String s) {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", list=" + list +
                '}';
    }

    /*
                1.使用构造注入
               1.1提供带所有参数的构造方法
             */
    public User(String username, Integer password, List<String> list) {
        this.username = username;
        this.password = password;
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
