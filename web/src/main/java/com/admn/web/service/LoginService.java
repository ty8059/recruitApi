package com.admn.web.service;

import com.admn.common.ResultEntity;

public interface LoginService {

    ResultEntity login(String username, String password);

}
