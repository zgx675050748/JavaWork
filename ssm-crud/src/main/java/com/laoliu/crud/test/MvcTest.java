package com.laoliu.crud.test;

import com.github.pagehelper.PageInfo;
import com.laoliu.crud.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author LaoLiu <br/>
 * @Description 使用Spring测试模块提供的测试请求功能 <br/>
 * @create 2021-03-17 11:29 <br/>
 * @since JDK 1.8
 */

@RunWith(SpringJUnit4ClassRunner.class)

//加此注解后，ioc容器本身也可以被自动注入
@WebAppConfiguration

@ContextConfiguration(locations = {"classpath:applicationContext.xml","file" +
        ":src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})

//Spring4测试时，需要servlet3.0支持，需要换servlet-api版本
public class MvcTest {
    //传入SpringMvc的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求
    MockMvc mockMvc;

    //@Before，每次测试都初始化
    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求，拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        //请求成功后，请求域中会有pageInfo，取出验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总页码："+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("页面中需要连续显示的页码");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int i :navigatepageNums) {
            System.out.print(i);
        }

        //获取员工数据
        List<Employee> list = pageInfo.getList();
        for (Employee employee :list) {
            System.out.println("ID："+employee.getEmpId()+"姓名："+employee.getEmpName());
        }

    }
}
