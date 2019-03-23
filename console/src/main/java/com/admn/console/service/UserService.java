package com.admn.console.service;

import com.admn.common.ResultEntity;
import com.admn.console.model.TblUser;

public interface UserService {
    TblUser findUserById(Integer userId);

    TblUser findUserByUsername(String username);

    ResultEntity addUser(TblUser user);


}
