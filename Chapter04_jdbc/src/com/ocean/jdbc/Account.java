package com.ocean.jdbc;
public class Account {
    private Integer id; //账户id
    private String username;//账户名
    private Double balance; //账户余额
    public Account() {
    }
    public Account(Integer id, String username, Double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
