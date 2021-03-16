package com.laoliu.spring5.dao;

import com.laoliu.spring5.entity.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    //添加到数据库
    @Override
    public void insert(UserDb userDb) {
        String sql1 = "insert into t_user values(?,?,?)";
        Object[] args = {userDb.getUserId(),
                userDb.getUserName(),
                userDb.getUstatus()};
        int cols = jdbcTemplate.update(sql1, args);
        System.out.println(cols);
    }

    //更新
    @Override
    public void update(UserDb userDb) {
        String sql1 = "update t_user set username=?,ustatus=? where user_id=?";
        Object[] args = {userDb.getUserName(),
                userDb.getUstatus(),
                userDb.getUserId()};
        int cols = jdbcTemplate.update(sql1, args);
        System.out.println(cols);
    }

    //删除
    @Override
    public void delete(UserDb userDb) {
        String sql1 = "delete from t_user where user_id=?";
        Object[] args = {userDb.getUserId()};
        int cols = jdbcTemplate.update(sql1, args);
        System.out.println(cols);
    }

    @Override
    public UserDb findOne(String id) {
        String sql1 = "select * from t_user where user_id=?";
        UserDb userDb = jdbcTemplate.queryForObject(sql1,
                new BeanPropertyRowMapper<UserDb>(UserDb.class),id);
        return userDb;
    }

    @Override
    public int findCount() {
        String sql1 = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql1,Integer.class);
    }

    @Override
    public List<UserDb> findList() {
        String sql1 = "select * from t_user";
        List<UserDb> query = jdbcTemplate.query(sql1,
                new BeanPropertyRowMapper<UserDb>(UserDb.class));
        return query;
    }

    @Override
    public void batchAdd(List<Object[]> args) {
        String sql1 = "insert into t_user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql1, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> args) {
        String sql1 = "delete from t_user where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql1, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql1 = "update t_user set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql1, args);
        System.out.println(Arrays.toString(ints));
    }
}
