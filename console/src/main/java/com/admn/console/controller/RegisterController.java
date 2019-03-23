package com.admn.console.controller;

import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.model.TblUser;
import com.admn.console.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("doRegister")
    public ResultEntity doRegister(@Valid TblUser user, BindingResult bindingResult) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return validResult;
        }
        return registerService.register(user);
    }
}
