package com.laoliu.spring5.test;


import com.laoliu.spring5.config.Config;
import com.laoliu.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.annotation.Resource;

//spring5整合junit5
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class JTest5 {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test1(){
        userService.accountMoney();
    }
}
