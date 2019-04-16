package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @Author wangyi
 * @Description 简历管理
 * @Date 2019/3/24 19:39
 * @Version 1.0
 */
@Controller
@RequestMapping("resume")
public class ResumeController {



    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/resume/resume");
        return modelAndView;
    }

    @RequestMapping("dataGrid")
    public Layui dataGrid(@Valid Page page, BindingResult bindingResult, String targetPosition) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return Layui.error(validResult.getMsg());
        }
        return null;
    }

    @GetMapping("invite")
    public ResultEntity invite(ModelAndView modelAndView) {
        return null;
    }

}
