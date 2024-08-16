package com.yupi.springbootinit.controller;

import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.model.entity.TodoTaskQueryBo;
import com.yupi.springbootinit.openFegin.MyService;
import com.yupi.springbootinit.openFegin.R;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 作废接口
     * @param taskId
     * @return
     */
    @GetMapping("/callRemoteInvalid")
    public R callRemoteInvalid(String taskId,String option) {
        if (taskId == null) {
            return R.error("参数不能为空");
        }
        return myService.callRemoteServiceInvalid(taskId,option);
    }


    /**
     * 获取流程代办接口内容
     */

    @PostMapping("/callRemoteProcess")
    public R callRemoteList2(@RequestBody TodoTaskQueryBo todoTaskQueryBo, @RequestParam String limit, @RequestParam String page) {
        if (todoTaskQueryBo == null) {
            return R.error("参数不能为空");
        }
        return myService.callRemoteServiceList2(todoTaskQueryBo,limit,page);
    }



}
