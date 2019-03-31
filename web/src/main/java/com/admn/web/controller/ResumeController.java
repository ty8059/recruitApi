package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author wangyi
 * @Description 简历管理
 * @Date 2019/3/24 19:39
 * @Version 1.0
 */
@Controller
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/user");
        return modelAndView;
    }

    @PostMapping("getResumeByUserId")
    @ResponseBody
    public ResultEntity getResume(Integer userId) {
        if (userId == null || userId <= 0) {
            return new ResultEntity(false, "userId非法");
        }
        return new ResultEntity(true, "获取resume成功", resumeService.findResumeByUserId(userId));
    }

    @PostMapping("addResume")
    @ResponseBody
    public ResultEntity addResume() {
        return null;
    }
}
