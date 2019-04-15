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

import javax.validation.Valid;

@RestController
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping("addPosition")
    public ResultEntity addPosition(@Valid TblPosition position, BindingResult bindingResult) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return new ResultEntity(false, validResult.getMsg());
        }
        return positionService.addPosition(position);
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
