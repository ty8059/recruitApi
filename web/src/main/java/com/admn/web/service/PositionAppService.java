package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblPositionApp;

import java.util.List;

public interface PositionAppService {
    List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status);

    ResultEntity applyPosition(Integer positionId, Integer userId);

    List<TblPositionApp> getAppByUserId(Integer userId);
}
