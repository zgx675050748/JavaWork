package com.laoliu.mapper;

import com.laoliu.domain.Order;
import com.laoliu.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//    注解实现一对多
    @Select("select * from user where id=#{id}")
    List<User> findById(int id);

    @Select("select * from user")
    @Results({
//            注：数据库字段名和实体属性名相同时，不使用Result也会自动注入
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.laoliu.mapper.OrderMapper" +
                            ".findByUid")
            )
    })
    List<User> findAllByUser();


    @Select("select u.*,ur.roleId from user u,sys_user_role ur where u.id=ur.userId")
    @Results({
            //            注：数据库查询出字段名和实体属性名相同时，不使用Result也会自动注入
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.laoliu.mapper.OrderMapper" +
                            ".findByUid")
            ),
            @Result(
                    property = "roleList",
                    column = "roleId",
                    javaType = List.class,
                    many = @Many(select = "com.laoliu.mapper.RoleMapper" +
                            ".findById")
            )

    })
    List<User> findUserAndRoleAll();
}
