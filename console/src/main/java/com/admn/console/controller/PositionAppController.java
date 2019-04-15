package com.admn.console.controller;

import com.admn.common.ResultEntity;
import com.admn.console.model.TblPositionApp;
import com.admn.console.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("positionApp")
public class PositionAppController {

    @Autowired
    private PositionAppService positionAppService;

    @RequestMapping("getAppListByAppTimeAndStatus")
    public ResultEntity getAppListByAppTimeAndStatus(String startTime, String endTime, String status) {
        List<TblPositionApp> list = positionAppService.getAppByAppTimeAndStatus(startTime, endTime, status);
        return new ResultEntity(true, "获取职位申请表成功", list);
    }
}
