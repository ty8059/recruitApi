package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.model.TblPositionApp;
import com.admn.console.service.PositionAppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("positionApp")
public class PositionAppController {

    @Autowired
    private PositionAppService positionAppService;

    @RequestMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("positionApp/positionApp");
        return modelAndView;
    }

    @RequestMapping("processAppForm")
    public ModelAndView processAppForm(Integer userId, Integer resumeId, Integer positionId, ModelAndView modelAndView) {
        modelAndView.setViewName("positionApp/processAppForm");
        if (userId == null) {
            modelAndView.addObject("errorMsg", "userId不能为空");
            return modelAndView;
        }
        if (resumeId == null) {
            modelAndView.addObject("errorMsg", "resumeId不能为空");
            return modelAndView;
        }
        if (positionId == null) {
            modelAndView.addObject("errorMsg", "positionId不能为空");
            return modelAndView;
        }
        TblPositionApp positionApp = positionAppService.getAppByUserIdAndPositionIdAndResumeId(userId, positionId, resumeId);
        modelAndView.addObject("positionApp", positionApp);
        return modelAndView;
    }

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
    public ResultEntity processApp(TblPositionApp positionApp, String status) {
        if (positionApp.getUserId() == null) {
            return new ResultEntity(false, "userId不能为空");
        } else if (positionApp.getPositionId() == null) {
            return new ResultEntity(false, "positionId不能为空");
        } else if (positionApp.getResumeId() == null) {
            return new ResultEntity(false, "resumeId不能为空");
        }
        if (StringUtils.isBlank(positionApp.getStatus())) {
            return new ResultEntity(false, "status不能为空");
        }
        return positionAppService.processApp(positionApp);
    }
}
