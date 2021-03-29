package com.laoliu.crud.service;


import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.bean.EmployeeExample;
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

    /*
    员工保存0
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void delEmpById(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void delBatchEmps(List<Integer> idList) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(idList);
        //delete from xxx whrere emp_id in(x ,x ,x);
        employeeMapper.deleteByExample(example);
    }
}
