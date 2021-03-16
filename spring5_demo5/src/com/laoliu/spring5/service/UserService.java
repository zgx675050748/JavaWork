package com.laoliu.spring5.service;

import com.laoliu.spring5.dao.UserDao;
import com.laoliu.spring5.entity.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    //添加的方法
    public void addUser(UserDb userDb){
        userDao.insert(userDb);
    }

    //更新
    public void updateUser(UserDb userDb){
        userDao.update(userDb);
    }

    //删除
    public void deleteUser(UserDb userDb){
        userDao.delete(userDb);
    }

    //查询记录数
    public int count(){
        return userDao.findCount();
    }

    //查询对象
    public UserDb findOne(String id){
        return userDao.findOne(id);
    }

    //查询对象集合
    public List<UserDb> findList(){
        return userDao.findList();
    }

    //批量添加
    public void batchAdd(List<Object[]> args){
        userDao.batchAdd(args);
    }

    //批量修改
    public void batchUpdate(List<Object[]> args){
        userDao.batchUpdate(args);
    }

    //批量删除
    public void batchDelete(List<Object[]> args){
        userDao.batchDelete(args);
    }
}
