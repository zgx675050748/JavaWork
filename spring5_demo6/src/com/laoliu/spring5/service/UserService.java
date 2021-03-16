package com.laoliu.spring5.service;

import com.laoliu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public void accountMoney(){

        //lucy少100
        userDao.produce();

        //模拟异常
        int a = 10/0;

        //mary多100
        userDao.add();


//        try {
//            //第一步 开启事务操作
//
//            //第二步 进行业务操作
//
//
//            //第三步 没有异常，提交事务
//        }
//        catch (Exception e){
//            //第四步 出现异常，事务回滚
//        }


    }
}
