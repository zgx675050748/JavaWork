package com.laoliu.dao.impl;

import com.laoliu.dao.UserDao;
import com.laoliu.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user",
                new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public Long saveUser(final User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator(){
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into sys_user " +
                                "values(?,?,?,?,?)",1);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,generatedKeyHolder);
        long userId = generatedKeyHolder.getKey().longValue();
//        jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",null,
//                user.getUsername(),user.getEmail(),user.getPassword(),
//                user.getPhoneNum());
        return userId;
    }

    public void saveUserRole(Long userId, Long[] roleIds) {
        for (Long roleId:roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",
                    userId, roleId);
        }
    }

    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    public void delUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where " +
                        "username=? and " +
                        "password=?", new BeanPropertyRowMapper<User>(User.class),
                username, password);
        return user;
    }
}
