package com.laoliu.crud.test;

import com.laoliu.crud.bean.Department;
import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.dao.DepartmentMapper;
import com.laoliu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;


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

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test1(){
        System.out.println(departmentMapper);

        //1.插入几个部门
//        departmentMapper.insertSelective(new Department(null, "开发部"));
//        departmentMapper.insertSelective(new Department(null, "测试部"));

        //2.生成员工数据，测试员工数据插入
//        employeeMapper.insertSelective(new Employee(null, "男","123456","张三",1));
//        employeeMapper.insertSelective(new Employee(null, "女","123456","李四",3));

        //3.批量插入员工，使用可以执行批量操作的sqlSession,一次插入n条数据
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0;i < 1000; i++){
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,"M",uid+"@laoliu.com",uid,
                    1));
        }
    }

}
