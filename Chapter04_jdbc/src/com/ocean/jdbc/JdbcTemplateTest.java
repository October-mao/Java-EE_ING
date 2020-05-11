package com.ocean.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    /**
     * 使用execute()方法建表
     * @param args
     */
    public static void main(String[] args) {
//        加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取JdbcTemplate实例
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        //使用execute方法执行sql语句，创建用户账户管理表account
        jdbcTemplate.execute("create table account(" +
                                  "id int primary key auto_increment," +
                                  "username varchar(50)," +
                                  "balance double)");
        System.out.println("账户表account创建成功！");
    }

    @org.junit.Test
    public void addAccountTest(){
        //        加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        //创建Account对象，并向Account对象中添加数据
        Account account = new Account();
        account.setUsername("rrrrr");
        account.setBalance(6666.00);
        //执行addAccount方法，并获取返回结果
        int num = accountDao.addAccount(account);
        if (num > 0 ){
            System.out.println("成功插入了" + num + "条数据");
        }else{
            System.out.println("插入操作执行失败");
        }
    }
    @Test
    public void updateAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        //创建Account对象，并向Account对象中添加数据
        Account account = new Account();
        account.setId(1);
        account.setUsername("ddddd");
        account.setBalance(66666.00);
        //执行updateAccount方法，并获取返回结果
        int num = accountDao.updateAccount(account);
        if (num > 0 ){
            System.out.println("成功修改了" + num + "条数据");
        }else{
            System.out.println("更新操作执行失败");
        }
    }
    @Test
    public void deleteAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        //执行updateAccount方法，并获取返回结果
        int num = accountDao.deleteAccount(1);
        if (num > 0 ){
            System.out.println("成功删除了" + num + "条数据");
        }else{
            System.out.println("删除操作执行失败");
        }
    }
    @Test
    public void findAccountByIdTest(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        //执行findAccountById方法
        Account account = accountDao.findAccountById(1);
        System.out.println(account.toString());
    }
    @Test
    public void findAllAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        //执行findAllAccount
        List<Account> account = accountDao.findAllAccount();
        //循环输出
        for (Account act:account) {
            System.out.println(act);
        }
    }
}
