package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblPositionApp;

public interface PositionAppService {
    TblPositionApp getAppByUserIdAndPositionIdAndResumeId(Integer userId, Integer positionId, Integer resumeId);

    Layui getAppByAppTimeAndStatus(String startTime, String endTime, String status, Page page);

    ResultEntity processApp(TblPositionApp positionApp);
}
