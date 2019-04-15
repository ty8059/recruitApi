package com.admn.console.service;

import com.admn.console.model.TblPositionApp;

import java.util.List;

public interface PositionAppService {
    List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status);
}
