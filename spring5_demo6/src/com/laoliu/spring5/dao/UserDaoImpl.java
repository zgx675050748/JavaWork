package com.laoliu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add() {
        String sql = "update account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void produce() {
        String sql = "update account set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
