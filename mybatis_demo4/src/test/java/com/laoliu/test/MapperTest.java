package com.laoliu.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoliu.domain.User;
import com.laoliu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        Date date = new Date();
        user.setUsername("zgx");
        user.setPassword("123");
        user.setBirthday(date);
        mapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User show = mapper.findById(8);
        System.out.println("--------------"+show.getBirthday()+
                "--------------");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        ????????????????????????
        PageHelper.startPage(1,3);
        List<User> all = mapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(all);
        System.out.println("????????????"+pageInfo.getPageNum());
        System.out.println("?????????????????????"+pageInfo.getPageSize());
        System.out.println("????????????"+pageInfo.getTotal());
        System.out.println("????????????"+pageInfo.getPages());
        System.out.println("????????????"+pageInfo.getPrePage());
        System.out.println("????????????"+pageInfo.getNextPage());
        System.out.println("?????????????????????"+pageInfo.isIsFirstPage());
        System.out.println("????????????????????????"+pageInfo.isIsLastPage());
        sqlSession.commit();
        sqlSession.close();
    }
}
