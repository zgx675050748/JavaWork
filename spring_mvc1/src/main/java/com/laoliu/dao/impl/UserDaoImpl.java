package com.laoliu.dao.impl;

import com.laoliu.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save方法执行-----------------------");
    }
}
