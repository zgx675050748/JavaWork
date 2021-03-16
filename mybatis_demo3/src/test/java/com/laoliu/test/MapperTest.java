package com.laoliu.test;

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
        user.setId(1);
//        user.setUsername("zhangs[an");
//        user.setPassword("123");
        List<User> all = mapper.findByCondition(user);
        System.out.println(all);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<User> byIds = mapper.findByIds(list);
        System.out.println(byIds);
    }
}
