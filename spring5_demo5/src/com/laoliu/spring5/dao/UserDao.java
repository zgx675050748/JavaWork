package com.laoliu.spring5.dao;

import com.laoliu.spring5.entity.UserDb;

import java.util.List;

public interface UserDao {
    void insert(UserDb userDb);

    void update(UserDb userDb);

    void delete(UserDb userDb);

    int findCount();

    UserDb findOne(String id);

    List<UserDb> findList();

    void batchAdd(List<Object[]> args);

    void batchUpdate(List<Object[]> args);

    void batchDelete(List<Object[]> args);
}
