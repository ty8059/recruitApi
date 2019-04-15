package com.admn.console.service.impl;

import com.admn.console.dao.TblPositionAppMapper;
import com.admn.console.model.TblPositionApp;
import com.admn.console.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionAppServiceImpl implements PositionAppService {

    @Autowired
    private TblPositionAppMapper positionAppMapper;

    @Override
    public List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status) {
        return positionAppMapper.findAppByAppTimeAndStatus(startTime, endTime, status);
    }
}
