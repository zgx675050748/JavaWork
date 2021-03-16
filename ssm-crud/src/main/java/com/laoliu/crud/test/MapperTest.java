package com.laoliu.crud.test;

import com.laoliu.crud.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author LaoLiu <br/>
 * @Description 测试层工作 <br/>
 * @create 2021-03-16 19:41 <br/>
 * @since JDK 1.8
 * 1.导入SpringTest模块
 * 2.使用@ContextConfiguration指定配置文件位置
 * 3.使用注解注入组件
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    //使用Spring的单元测试，自动注入组件
    //测试DepartmentMapper
    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void test1(){
        System.out.println(departmentMapper);
    }

}
