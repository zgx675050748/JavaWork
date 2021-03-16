package com.laoliu.mapper;

import com.laoliu.domain.Order;
import com.laoliu.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    //注解实现一对一

    @Select("select * from orders")
    @Results({
            //            注：数据库字段名和实体属性名相同时，不使用Result也会自动注入
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.laoliu.mapper.UserMapper.findById")
//                    直接利用其他实体的查询方法，column作为参数传递
            )
    })
    List<Order> findAllByOrder();


    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);
}
