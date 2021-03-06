package com.laoliu.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.bean.Msg;
import com.laoliu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LaoLiu <br/>
 * @Description 处理员工的增删改查 <br/>
 * @create 2021-03-17 11:06 <br/>
 * @since JDK 1.8
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*
    批量删除：1-2-3
    单个删除：1
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delEmpById(@PathVariable(value = "id") String ids){
        if (ids.contains("-")){
            List<Integer> idList = new ArrayList<>();
            for (String s : ids.split("-")) {
                idList.add(Integer.parseInt(s));
            }
            employeeService.delBatchEmps(idList);
        }else {
            int id = Integer.parseInt(ids);
            employeeService.delEmpById(id);
        }
        return Msg.success();
    }

    /*
    更新员工
     */
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee){

        employeeService.updateEmp(employee);
        return Msg.success();
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp",employee);
    }

    /*
    保存员工信息

     */
    @RequestMapping(value="/saveemp" ,method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            Map<String, Object> map = new HashMap<String, Object>();
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println("错误的字段"+fieldError.getField());
                System.out.println("错误信息"+fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }
        employeeService.saveEmp(employee);
        return Msg.success();
    }


    /*
    需要导入 jackson包
    将PageInfo对象转换为json格式数据，传入客户端
     */
    @ResponseBody
    @RequestMapping("/emps")
    public Msg getAllEmpsWithJson(@RequestParam(value = "pn",
            defaultValue = "1")Integer pn){
        //查询所有，不需要条件，传入参数null即可
        //数据非常多，没有分页，引入PageHelper分页插件
        //在查询之前只需调用，传入页码和每页记录条数
        PageHelper.startPage(pn,10);
        //startPage后紧跟的查询，就是一个分页查询
        List<Employee> employeeList = employeeService.getAll();
        //可以使用PageInfo对查出数据进行包装，将pageInfo交给页面
        //封装了详细的分页信息，包括查询出的数据,navigatePages：连续显示多少页
        PageInfo pageInfo = new PageInfo(employeeList, 5);

        //将pageInfo封装至Msg中返回
        return Msg.success().add("pageInfo",pageInfo);
    }

    /*
    查询员工数据（分页查询）
     */



    //@RequestMapping("/emps")
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
