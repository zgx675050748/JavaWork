package com.laoliu.spring5.service;

import javax.annotation.Resource;
import com.laoliu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//在注解例value属性值可以省略不写,默认值为类名首字母小写
@Service
public class UserService {

    @Autowired
    private List<UserDao> userDaoList;

    @Autowired
    private Map<String,UserDao> userDaoMap;

    @Autowired
    @Qualifier(value = "userDaoImpl2")
    private UserDao userDao2;

    @Resource(name = "userDaoImpl2")
    private UserDao userDao3;

    public void add(){
        System.out.println("123456");
        System.out.println(userDaoList);
        System.out.println(userDaoMap);
        userDao2.add();
        userDao3.add();
    }
}
