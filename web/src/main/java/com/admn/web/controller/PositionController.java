package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping("getPositionList")
    public ResultEntity getPositionList() {
        return new ResultEntity(true, "获取职位表成功", positionService.getPositionList());
    }
}
