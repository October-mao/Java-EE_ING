package com.ocean.test;

import com.ocean.po.Customer;
import com.ocean.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * 入门程序测试类
 */
public class MybatisTest {
    /**
     * 根据客户姓名和职业条件组合查询客户信息
     */
    @Test
    public void findCustomerByNameAndJobsTest(){
        //通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        //创建Customer对象，封装需要组合的查询条件
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        //执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.ocean.mapper.CustomerMapper.findCustomerByNameAndJobs",customer);
        //输出查询结果信息
        for (Customer customer2:customers
             ) {
            System.out.println(customer2);
        }
        //关闭SqlSession
        session.close();
    }

    /**
     * 根据客户姓名和职业条件组合查询客户信息
     */
    @Test
    public void findCustomerByNameOrJobsTest(){
        //通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        //创建Customer对象，封装需要组合的查询条件
        Customer customer = new Customer();
        //customer.setUsername("jack");
        //customer.setJobs("teacher");
        //执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.ocean.mapper.CustomerMapper.findCustomerByNameOrJobs",customer);
        //输出查询结果信息
        for (Customer customer2:customers
        ) {
            System.out.println(customer2);
        }
        //关闭SqlSession
        session.close();
    }
}
