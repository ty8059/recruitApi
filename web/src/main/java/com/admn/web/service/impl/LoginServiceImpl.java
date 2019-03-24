package com.admn.web.service.impl;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblUser;
import com.admn.web.service.LoginService;
import com.admn.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public ResultEntity login(String username, String password) {
        TblUser user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResultEntity(false, "登录失败, 用户名不存在");
        } else {
            if (!user.getPassword().equals(password)) {
                return new ResultEntity(false, "登录失败, 密码错误");
            } else {
                return new ResultEntity(true, "登录成功", user);
            }
        }
    }



}
