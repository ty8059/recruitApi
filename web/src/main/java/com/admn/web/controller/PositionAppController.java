package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
