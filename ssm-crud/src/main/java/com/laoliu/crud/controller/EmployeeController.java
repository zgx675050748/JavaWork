package com.laoliu.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LaoLiu <br/>
 * @Description 处理员工的增删改查 <br/>
 * @create 2021-03-17 11:06 <br/>
 * @since JDK 1.8
 */

@Controller
public class EmployeeController {

    /*
    查询员工数据（分页查询）
     */

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/emps")

    public String getAllEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //查询所有，不需要条件，传入参数null即可
        //数据非常多，没有分页，引入PageHelper分页插件
        //在查询之前只需调用，传入页码和每页记录条数
        PageHelper.startPage(pn,5);
        //startPage后紧跟的查询，就是一个分页查询
        List<Employee> employeeList = employeeService.getAll();
        //可以使用PageInfo对查出数据进行包装，将pageInfo交给页面
        //封装了详细的分页信息，包括查询出的数据,navigatePages：连续显示多少页
        PageInfo pageInfo = new PageInfo(employeeList, 5);
        //封装至model
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }
}
