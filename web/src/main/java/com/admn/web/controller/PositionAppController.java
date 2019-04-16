package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblPositionApp;
import com.admn.web.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("positionApp")
public class PositionAppController {

    @Autowired
    private PositionAppService positionAppService;

    @RequestMapping("applyPosition")
    public ResultEntity applyPosition(Integer positionId, Integer userId) {
        if (userId == null) {
            return new ResultEntity(false, "userId不能为空");
        }
        if (positionId == null) {
            return new ResultEntity(false, "positionId不能为空");
        }
        return positionAppService.applyPosition(positionId, userId);
    }

    @RequestMapping("getPositionAppByUserId")
    public ResultEntity getPositionAppByUserId(Integer userId) {
        if (userId == null || userId == 0) {
            return new ResultEntity(false, "userId不能非法");
        }
        List<TblPositionApp> list = positionAppService.getAppByUserId(userId);
        return new ResultEntity(true, "获取申请记录成功", list);
    }
}
