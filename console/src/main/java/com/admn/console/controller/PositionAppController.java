package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("positionApp")
public class PositionAppController {

    @Autowired
    private PositionAppService positionAppService;

    @RequestMapping("dataGrid")
    public Layui dataGrid(@Valid Page page, BindingResult bindingResult,
                          String startTime, String endTime, String status) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return Layui.data(0, null, validResult.getMsg());
        }
        return positionAppService.getAppByAppTimeAndStatus(startTime, endTime, status, page);
    }
}
