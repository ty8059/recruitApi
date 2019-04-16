package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.model.TblPosition;
import com.admn.console.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("position/position");
        return modelAndView;
    }

    @RequestMapping("addPosition")
    public ResultEntity addPosition(@Valid TblPosition position, BindingResult bindingResult) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return new ResultEntity(false, validResult.getMsg());
        }
        return positionService.addPosition(position);
    }

    @RequestMapping("editPosition")
    public ResultEntity editPosition(@Valid TblPosition position, BindingResult bindingResult) {
        if (position.getPositionId() == null) {
            return new ResultEntity(false ,"positionId不能为空");
        }
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return new ResultEntity(false, validResult.getMsg());
        }
        return positionService.editPosition(position);
    }

    @RequestMapping("dataGrid")
    public Layui dataGrid(@Valid Page page, BindingResult bindingResult, String positionName) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return Layui.error(validResult.getMsg());
        }
        return positionService.getByPositionName(positionName,page);
    }

}
