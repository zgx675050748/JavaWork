package com.laoliu.service.impl;

import com.laoliu.dao.UserDao;
import com.laoliu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    public void show() {
        userDao.save();
    }
}
