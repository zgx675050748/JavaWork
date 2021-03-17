package com.laoliu.crud.service;


import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LaoLiu <br/>
 * @Description <br/>
 * @create 2021-03-17 11:09 <br/>
 * @since JDK 1.8
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /*
    查询所有员工
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
