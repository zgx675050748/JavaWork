package com.laoliu.controller;

import com.laoliu.domain.Account;
import com.laoliu.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) throws IOException {
        accountService.save(account);
        return "保存成功";
    }


    @RequestMapping("/accountList")
    //查询
    public ModelAndView find() throws IOException {
        List<Account> accountList = accountService.findAllByAccount();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accountList");
        modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }
}
