package com.admn.console.service;

import com.admn.common.ResultEntity;

public interface LoginService {

    ResultEntity login(String username, String password);

}
