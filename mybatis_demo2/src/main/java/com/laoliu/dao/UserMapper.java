package com.laoliu.dao;

import com.laoliu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

//    使用注解开发简单sql
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(int id);
}
