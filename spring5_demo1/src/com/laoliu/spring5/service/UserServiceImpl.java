package com.laoliu.spring5.service;

import com.laoliu.spring5.dao.UserDao;

public class UserServiceImpl implements UserService{

    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void showService() {
        System.out.println("UserService+++++++++");
        userDao.showDao();
    }
}
