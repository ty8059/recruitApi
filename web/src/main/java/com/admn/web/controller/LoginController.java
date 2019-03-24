package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("doLogin")
    public ResultEntity doLogin(String username, String password) {
        if (username == null || "".equals(username)) {
            return new ResultEntity(false, "请输入用户名");
        }
        if (password == null || "".equals(password)) {
            return new ResultEntity(true, "请输入密码");
        }
        return loginService.login(username, password);
    }
}
