package com.laoliu.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    /*
        参数Exception：异常对象
        返回值ModelAndView：跳转到错误视图信息
    */
public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }
        else if(e instanceof ArithmeticException){
            modelAndView.addObject("info","算数运算异常");
        }

        modelAndView.setViewName("500");
        return modelAndView;
    }
}
