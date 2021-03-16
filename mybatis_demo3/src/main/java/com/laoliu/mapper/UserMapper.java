package com.laoliu.mapper;

import com.laoliu.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findByCondition(User user);

    List<User> findByIds(List<Integer> ids);

}
