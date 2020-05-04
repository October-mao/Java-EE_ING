package com.ocean.test;

import com.ocean.po.Customer;
import com.ocean.po.User;
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
     * 一级缓存测试
     * 缓存在sqlSession里
     * 默认开启
     */
    @Test
    public void cacheOneTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = sqlSession.selectOne("com.ocean.po.CustomerMapper.findCustomerById",1);
        System.out.println(customer.toString());
        //清空1级缓存
        sqlSession.commit();
        //第二次查询先查询1级缓存
        customer = sqlSession.selectOne("com.ocean.po.CustomerMapper.findCustomerById",1);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    /**
     * 二级缓存测试
     * 缓存在SqlSessionFactory
     * 需要手动开启
     * 二级缓存查询的对象需要实现序列划接口
     */
    @Test
    public void cacheTwoTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = sqlSession.selectOne("com.ocean.po.CustomerMapper.findCustomerById",1);
        System.out.println(customer.toString());
        //与下面的sqlSession不是同一个，所以这里可以关闭
        sqlSession.close();

        //第二个会话查询，二级缓存
        //获取新的会话
        sqlSession = MybatisUtils.getSession();
        customer = sqlSession.selectOne("com.ocean.po.CustomerMapper.findCustomerById",1);
        System.out.println(customer.toString());
        sqlSession.close();
    }





    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findCustomerByIdTest()throws Exception{
        //通过工具类获取会话
        SqlSession sqlSession = MybatisUtils.getSession();
//        4、sqlSession执行映射文件中定义的sql，并返回映射结果
//        第一个参数是sql的id,第二个参数是传入给sql的占位符的参数
        Customer customer = sqlSession.selectOne("com.ocean.po.CustomerMapper.findCustomerById",1);
        //打印输出结果
        System.out.println(customer.toString());
//        关闭sqlSession
        sqlSession.close();
    }


    /**
     * 根据用户名称模糊查询用户信息列表
     */
    @Test
    public void findCustomerByNameTest() throws IOException {
//        1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3、通过SqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4、sqlSession执行映射文件中定义的sql，并返回映射结果
//        第一个参数是sql的id,第二个参数是传入给sql的占位符的参数
        List<Customer> list = sqlSession.selectList("com.ocean.po.CustomerMapper.findCustomerByName","o");
        //打印输出结果
        for (Customer c : list) {
            System.out.println(c);
        }
        sqlSession.close();
    }

    /**
     * 添加客户信息
     */
    @Test
    public void addCustomer() throws Exception{
//        1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3、通过SqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4、sqlSession执行映射文件中定义的sql，并返回映射结果
//        创建customer对象,并添加数据
        Customer customer = new Customer();
        customer.setUsername("rose");
        customer.setJobs("student");
        customer.setPhone("44444444");
//        执行SqlSession的插入方法,返回的是sql语句影响的行数
        int rows =sqlSession.insert("com.ocean.po.CustomerMapper.addCustomer",customer);
//        通过返回结果判断插入操作是否执行成功
        if (rows > 0){
            System.out.println("您成功插入了"+rows+"条数据!");
        }else {
            System.out.println("执行插入操作失败!");
        }
//        重点!提交事务---增删改都涉及到事务,需要提交事务
        sqlSession.commit();
        System.out.println(customer.getId());
        sqlSession.close();
    }

    /**
     * 更新客户信息
     */
    @Test
    public void updateCustomer() throws Exception{
//        1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3、通过SqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4、sqlSession执行映射文件中定义的sql，并返回映射结果
//        创建customer对象,并添加数据
        Customer customer = new Customer();
        customer.setId(4);
        customer.setUsername("rose");
        customer.setJobs("cook");
        customer.setPhone("44444444");
//        执行SqlSession的更新方法,返回的是sql语句影响的行数
        int rows =sqlSession.update("com.ocean.po.CustomerMapper.updateCustomer",customer);
//        通过返回结果判断更新操作是否执行成功
        if (rows > 0){
            System.out.println("您成功更新了"+rows+"条数据!");
        }else {
            System.out.println("执行更新操作失败!");
        }
//        重点!提交事务---增删改都涉及到事务,需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除客户信息
     */
    @Test
    public void deleteCustomer() throws Exception{
//        1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3、通过SqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4、sqlSession执行映射文件中定义的sql，并返回映射结果
//        执行SqlSession的删除方法,返回的是sql语句影响的行数
        int rows =sqlSession.delete("com.ocean.po.CustomerMapper.deleteCustomer",4);
//        通过返回结果判断删除操作是否执行成功
        if (rows > 0){
            System.out.println("您成功删除了"+rows+"条数据!");
        }else {
            System.out.println("执行删除操作失败!");
        }
//        重点!提交事务---增删改都涉及到事务,需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试resultMap
     */
    @Test
    public void findAllUserTest(){
        //通过工具类获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        //使用sqlSession执行映射文件定义的sql,返回映射结果集
        List<User> users = sqlSession.selectList("com.ocean.po.User.findAllUser");
        for (User u :
                users) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}
