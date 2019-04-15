package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;

public interface PositionAppService {
    Layui getAppByAppTimeAndStatus(String startTime, String endTime, String status, Page page);
}
