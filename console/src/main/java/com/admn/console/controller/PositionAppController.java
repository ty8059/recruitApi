package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.service.PositionAppService;
import org.apache.commons.lang3.StringUtils;
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
            return Layui.error(validResult.getMsg());
        }
        return positionAppService.getAppByAppTimeAndStatus(startTime, endTime, status, page);
    }

    @RequestMapping("processApp")
    public ResultEntity processApp(Integer userId, Integer positionId, Integer resumeId, String status) {
        if (userId == null) {
            return new ResultEntity(false, "userId不能为空");
        } else if (positionId == null) {
            return new ResultEntity(false, "positionId不能为空");
        } else if (resumeId == null) {
            return new ResultEntity(false, "resumeId不能为空");
        }
        if (StringUtils.isBlank(status)) {
            return new ResultEntity(false, "status不能为空");
        }
        return positionAppService.processApp(userId, positionId, resumeId, status);
    }
}
