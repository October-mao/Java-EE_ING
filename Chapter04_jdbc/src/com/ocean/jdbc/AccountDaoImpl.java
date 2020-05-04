package com.ocean.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
//    声明JdbcTemplate属性及其setter方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //添加账户
    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(username,balance) value(?,?)";
        //定义数组来存放SQL语句中的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        //执行添加账户操作，返回受影响的sql条数
        return this.jdbcTemplate.update(sql,obj);
    }
    //更新账户
    @Override
    public int updateAccount(Account account) {
        //定义sql语句
        String sql = "update account set username=? , balance=? where id = ?";
        //定义数组来存放sql语句的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        return this.jdbcTemplate.update(sql,obj);
    }
    //删除账户
    @Override
    public int deleteAccount(int id) {
        //定义sql语句
        String sql = "delete from account where id=?";
        return this.jdbcTemplate.update(sql,id);
    }
    //通过id查询账户信息
    @Override
    public Account findAccountById(int id) {
        //定义sql语句
        String sql = "select * from account where id=?";
        //创建一个新的rowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //将id绑定到SQL语句中，通过RowMapper返回一个object类型的单行记录
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    //查询所有账户信息
    @Override
    public List<Account> findAllAccount() {
        //定义sql语句
        String sql = "select * from account";
        //创建一个新的rowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行静态的sql查询，通过RowMapper返回结果
        return this.jdbcTemplate.query(sql,rowMapper);
    }
}
