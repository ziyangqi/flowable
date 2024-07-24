package com.yupi.springbootinit.controller;

import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.openFegin.MyService;
import com.yupi.springbootinit.openFegin.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Resource
    private MyService myService;

    /**
     * 认证的内容
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("/callRemote")
    public R callRemote(String userName ,String password) {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername(userName);
        loginForm.setPassword(password);
        return myService.callRemoteService(loginForm);
    }

    // 作废接口



}
