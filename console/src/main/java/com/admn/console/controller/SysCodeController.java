package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.model.TblSysCode;
import com.admn.console.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("sysCode")
public class SysCodeController {

    @Autowired
    private SysCodeService sysCodeService;

    @RequestMapping()
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("sysCode/sysCode");
        return modelAndView;
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public Layui dataGrid(@Valid Page page, BindingResult bindingResult,
                          TblSysCode sysCode) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return Layui.error(validResult.getMsg());
        }
        return sysCodeService.findBySysCodeAndPage(sysCode, page);
    }
}
