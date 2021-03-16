package com.laoliu.service.impl;

import com.laoliu.dao.RoleDao;
import com.laoliu.dao.UserDao;
import com.laoliu.domain.Role;
import com.laoliu.domain.User;
import com.laoliu.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;

    public List<User> list() {
        List<User> userList = userDao.findAll();
//        封装userList中的每一个roles数据
        for (User user: userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId = userDao.saveUser(user);
        userDao.saveUserRole(userId,roleIds);
    }

    public void del(Long userId) {
//        1、删除关系表数据
        userDao.delUserRole(userId);
        int a = 1/0;
//        2、删除user表数据
        userDao.delUser(userId);
    }

    public User login(String username, String password) {
        try {
            User user = userDao.findByUsernameAndPassword(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
