package com.laoliu.spring5.dao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

@Order(2)
@Repository
public class UserDaoImpl1 implements UserDao {
    @Override
    public void add() {
        System.out.println("123456789");
    }
}
