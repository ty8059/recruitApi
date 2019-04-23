package com.admn.console.controller;

import com.admn.common.ResultEntity;
import com.admn.console.model.TblUser;
import com.admn.console.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("login")
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("doLogin")
    public ResultEntity doLogin(String username, String password, HttpSession session) {
        if (username == null || "".equals(username)) {
            return new ResultEntity(false, "请输入用户名");
        }
        if (password == null || "".equals(password)) {
            return new ResultEntity(true, "请输入密码");
        }
        ResultEntity resultEntity = loginService.login(username, password);
        if (resultEntity.isSuccess()) {
            session.setAttribute("sysUser", (TblUser) resultEntity.getObj());
        }
        return resultEntity;
    }
}
