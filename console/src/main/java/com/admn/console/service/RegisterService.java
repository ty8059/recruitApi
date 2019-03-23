package com.admn.console.service;

import com.admn.common.ResultEntity;
import com.admn.console.model.TblUser;

public interface RegisterService {

    ResultEntity register(TblUser user);
}
