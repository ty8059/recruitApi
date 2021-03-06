package com.admn.console.service.impl;

import com.admn.common.ResultEntity;
import com.admn.console.dao.TblUserMapper;
import com.admn.console.model.TblUser;
import com.admn.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TblUserMapper userMapper;

    @Override
    public TblUser findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public TblUser findUserByUsername(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public ResultEntity addUser(TblUser user) {
        int result = userMapper.insertSelective(user);
        if (result <= 0) {
            return new ResultEntity(false, "添加用户失败");
        } else {
            return new ResultEntity(true, "添加用户成功");
        }
    }
}
