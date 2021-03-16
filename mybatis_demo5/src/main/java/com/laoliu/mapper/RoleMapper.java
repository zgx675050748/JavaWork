package com.laoliu.mapper;

import com.laoliu.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role where id=#{id}")
    List<Role> findById(int id);
}
