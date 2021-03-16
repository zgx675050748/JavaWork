package com.laoliu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laoliu.model.UserModel;
import com.laoliu.model.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller(value = "userController")
@RequestMapping("user")
public class UserController {

    //请求地址 http://localhost:8080/user/show
    @RequestMapping(value = "/show",method = RequestMethod.GET,params = {
            "username"
    })
    public String show(){
        System.out.println("UserController.............");
        return "/success.jsp";
    }

    @RequestMapping(value = "/show1")
    public ModelAndView show1(){
        /*
        * Model:模型 作用封装数据
        * View：视图 作用展示数据
        * */
        ModelAndView modelAndView = new ModelAndView();
//        设置模型数据
        modelAndView.addObject("username","zgx1");
//        设置视图名称
        modelAndView.setViewName("/success");

        return modelAndView;
    }


    @RequestMapping(value = "/show2")
    public ModelAndView show2(ModelAndView modelAndView){
        modelAndView.addObject("username","zgx2");
        modelAndView.setViewName("/success");
        return modelAndView;
    }

//    单独使用model配合字符串返回页面
    @RequestMapping(value = "/show3")
    public String show3(Model model){
        model.addAttribute("username","zgx3");
        return "/success";
    }

//    通过request向前端传输数据
    @RequestMapping(value = "/show4")
    public String show4(HttpServletRequest request){
        request.setAttribute("username","zgx4");
        return "/success";
    }

//    通过response向前端响应信息
    @RequestMapping(value = "/show5")
    public void show5(HttpServletResponse response) throws IOException {
        response.getWriter().print("zgx5");
    }

//    使用@ResponseBody注解，可以向前端直接return响应信息，效果和response.getWriter().print（）类似
    @RequestMapping(value = "/show6")
    @ResponseBody
    public String show6() {
        return "zgx6";
    }

//    使用@ResponseBody注解，可以向前端直接return响应json格式数据
    @RequestMapping(value = "/show7")
    @ResponseBody
    public String show7() {
        return "{\"username\":\"zgx7\"}";
    }

//    使用jackson将对象转换为json数据格式字符串
    @RequestMapping(value = "/show8")
    @ResponseBody
    public String show8() throws JsonProcessingException {
        UserModel userModel = new UserModel();
        userModel.setUsername("zgx8");
        userModel.setPassword("zgx8");
//        使用jackson将对象转为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userModel);
        return json;
    }

//    使用SpringMVC自动将返回的对象转换为json格式
    @RequestMapping(value = "/show9")
    @ResponseBody
    public UserModel show9() throws JsonProcessingException {
        UserModel userModel = new UserModel();
        userModel.setUsername("zgx9");
        userModel.setPassword("zgx9");
//        期望SpringMVC自动将UserModel转换为json字符串,需在spring-mvc.xml中配置转换器
        return userModel;
    }

//    使用<mvc:annotation-driven/>简化json转换配置
    @RequestMapping(value = "/show10")
    @ResponseBody
    public UserModel show10() throws JsonProcessingException {
        UserModel userModel = new UserModel();
        userModel.setUsername("zgx10");
        userModel.setPassword("zgx10");
//        在spring-mvc.xml中配置转换器太过繁琐，使用<mvc:annotation-driven/>后，不需要再进行原始的配置
        return userModel;
    }

//    SpringMVC可以根据前端传输数据的键名，在参数列表中使用与键名相同的变量获取到值
    @RequestMapping(value = "/show11")
    @ResponseBody
    public void show11(String username,int age) throws JsonProcessingException {
        System.out.println(username);
        System.out.println(age);
    }

//    SpringMVC可以根据前端传输数据的键名和实体的属性名进行匹配，自动注入
    @RequestMapping(value = "/show12")
    @ResponseBody
    public void show12(UserModel userModel) {
        System.out.println(userModel.getUsername());
        System.out.println(userModel.getPassword());
    }

//    SpringMVC可以将多个键名相同的数据传入到数组中
    @RequestMapping(value = "/show13")
    @ResponseBody
    public void show13(String[] usernames) {
        System.out.println(Arrays.asList(usernames));
    }

//    SpringMVC可以使用实例内集合，实现集合形式参数的传输，VO中包含某一类型集合的属性
    @RequestMapping(value = "/show14")
    @ResponseBody
    public void show14(VO vo) {
        System.out.println(vo);
    }

//    使用ajax可以直接将前端的集合传入参数中，需要使用@RequestBody注解，无需使用实例内集合
    @RequestMapping(value = "/show15")
    @ResponseBody
    public void show15(@RequestBody List<UserModel> userModelList) {
        System.out.println(userModelList);
    }

//    如果前端传输的数据键和参数列表中不同，可以使用@RequestParam进行匹配映射，其中还有以下参数
//    required：此在指定的请求参数是否必须包括，默认是true
//    defaultValue：当没有指定请求参数时，使用指定的默认值赋值
    @RequestMapping(value = "/show16")
    @ResponseBody
    public void show16(@RequestParam(value = "name",required = false,
            defaultValue = "laoliu") String username) {
        System.out.println(username);
    }

//    Restful风格参数获取
//    例   http:localhost:8080/show17/张三/25
    @RequestMapping(value = "/show17/{name}/{age}")
    @ResponseBody
    public void show17(@PathVariable("name") String username,@PathVariable(
            "age") int age) {
        System.out.println(username);
        System.out.println(age);
    }

//    参数列表获取原生api
    @RequestMapping(value = "/show18")
    @ResponseBody
    public void show18(HttpServletRequest request,
                       HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

//    获取请求头数据使用@RequestHeader注解，@CookieValue注解获取请求头中Cookie,Cookie中数据是键值对
    @RequestMapping(value = "/show19")
    @ResponseBody
    public void show19(@RequestHeader("User-Agent")String user_agent,
                      @CookieValue(name = "JSESSIONID") String cookie) {
        System.out.println(user_agent);
        System.out.println(cookie);
    }

//    文件上传，多文件上传可以使用数组
    @RequestMapping(value = "/show20")
    @ResponseBody
    public void show20(MultipartFile file) throws IOException {
        System.out.println(file);
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File("C:\\upload\\"+originalFilename));
    }

//    多文件上传 
    @RequestMapping(value = "/show21")
    @ResponseBody
    public void show21(MultipartFile[] files) throws IOException {
        System.out.println(Arrays.asList(files));
        for (MultipartFile file:files) {
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("C:\\upload\\"+originalFilename));
        }
    }

}
