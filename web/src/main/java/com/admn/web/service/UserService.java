package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblUser;

public interface UserService {
    TblUser findUserById(Integer userId);

    TblUser findUserByUsername(String username);

    ResultEntity addUser(TblUser user);


}
