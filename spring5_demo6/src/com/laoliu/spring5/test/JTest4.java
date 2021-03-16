package com.laoliu.spring5.test;

import com.laoliu.spring5.config.Config;
import com.laoliu.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


//spring5整合junit4
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class JTest4 {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }
}
