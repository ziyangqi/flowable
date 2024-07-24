package com.yupi.springbootinit.model.entity;

import lombok.Data;

/**
 * 登录表单
 */
@Data
public class LoginForm {

    private String username;

    private String password;
    private String phoneNum;

}
