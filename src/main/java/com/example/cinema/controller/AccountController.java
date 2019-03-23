package com.example.cinema.controller;

import com.example.cinema.bl.AccountServiceImpl;
import com.example.cinema.config.InterceptorConfiguration;
import com.example.cinema.dao.User;
import com.example.cinema.po.UserForm;
import com.example.cinema.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author huwen
 * @date 2019/3/23
 */
@RestController()
public class AccountController {
    private final static String ACCOUNT_INFO_ERROR="用户名或密码错误";
    @Autowired
    private AccountServiceImpl accountService;
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm, HttpSession session){
        User user = accountService.login(userForm);
        if(user==null){
           return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        //注册session
        session.setAttribute(InterceptorConfiguration.SESSION_KEY,userForm);
        return ResponseVO.buildSuccess(user);
    }
    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserForm userForm){
        return accountService.registerAccount(userForm);
    }

    @PostMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute(InterceptorConfiguration.SESSION_KEY);
        return "index";
    }
}
