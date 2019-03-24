package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblUser;

public interface RegisterService {

    ResultEntity register(TblUser user);
}
