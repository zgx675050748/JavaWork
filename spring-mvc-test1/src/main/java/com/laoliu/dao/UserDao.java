package com.laoliu.dao;

import com.laoliu.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long saveUser(User user);

    void saveUserRole(Long userId, Long[] roleIds);

    void delUser(Long userId);

    void delUserRole(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
