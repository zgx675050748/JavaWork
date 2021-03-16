package com.laoliu.interceptor;

import com.laoliu.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        判断用户是否登录，本质是判断session中有无user对象
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null){
            //没有登陆
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
//        登录，放行
        return true;
    }
}
