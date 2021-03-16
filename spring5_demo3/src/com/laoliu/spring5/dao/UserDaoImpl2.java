package com.laoliu.spring5.dao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

@Order(1)
@Repository
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("789456123");
    }
}
