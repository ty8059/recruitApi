package com.admn.web.service;

import com.admn.web.model.TblPositionApp;

import java.util.List;

public interface PositionAppService {
    List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status);
}
