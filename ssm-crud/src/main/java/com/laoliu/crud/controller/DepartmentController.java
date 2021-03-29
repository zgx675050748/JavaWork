package com.laoliu.crud.controller;

import com.laoliu.crud.bean.Department;
import com.laoliu.crud.bean.Msg;
import com.laoliu.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LaoLiu <br/>
 * @Description 处理部门相关请求 <br/>
 * @create 2021-03-17 17:06 <br/>
 * @since JDK 1.8
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /*
    返回所有部门信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getAllDepts(){
        List<Department> departmentList = departmentService.getDepts();
        return Msg.success().add("depts",departmentList);
    }


}
