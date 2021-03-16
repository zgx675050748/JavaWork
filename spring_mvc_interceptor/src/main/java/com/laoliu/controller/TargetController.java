package com.laoliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show1(){
        System.out.println("目标资源执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","老六");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
