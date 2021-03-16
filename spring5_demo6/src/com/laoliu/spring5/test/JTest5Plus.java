package com.laoliu.spring5.test;

import com.laoliu.spring5.config.Config;
import com.laoliu.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;


//spring5整合junit5，使用一条注解代替两条
@SpringJUnitConfig(classes = Config.class)
public class JTest5Plus {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }
}
