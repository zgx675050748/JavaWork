package com.laoliu.dao.impl;

import com.laoliu.dao.RoleDao;
import com.laoliu.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role",
                new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null,
                role.getRoleName(),role.getRoleDesc());
    }

    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where " +
                        "ur.roleId=r.id and ur.userId=?",
                new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
