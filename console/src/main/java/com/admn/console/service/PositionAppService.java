package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;

public interface PositionAppService {
    Layui getAppByAppTimeAndStatus(String startTime, String endTime, String status, Page page);

    ResultEntity processApp(Integer userId, Integer positionId, Integer resumeId, String status);
}
