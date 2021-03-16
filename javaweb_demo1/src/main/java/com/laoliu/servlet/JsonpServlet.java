package com.laoliu.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exist",1);
        jsonObject.put("msg","用户名已存在");
        if (username.equals("123456")){
            jsonObject.put("exist",0);
            jsonObject.put("msg","注册成功");
        }
        if (req.getParameter("callback")==null){
            resp.getWriter().print("handle("+ JSON.toJSONString(jsonObject)+")");
        }
        else {
            resp.getWriter().print(req.getParameter("callback")+"("+ JSON.toJSONString(jsonObject)+")");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


}
