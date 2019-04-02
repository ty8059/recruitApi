package com.admn.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/resume/resume");
        return modelAndView;
    }

    @GetMapping("resumeForm")
    public ModelAndView resumeForm(ModelAndView modelAndView) {
        modelAndView.addObject("wuzhaoyu", "sb");
        modelAndView.setViewName("/resume/resumeForm");
        return modelAndView;
    }

    @GetMapping("invite")
    public ModelAndView invite(ModelAndView modelAndView) {
        modelAndView.setViewName("/resume/invite");
        return modelAndView;
    }

    @GetMapping("inviteForm")
    public ModelAndView inviteForm(ModelAndView modelAndView) {
        modelAndView.setViewName("/resume/inviteForm");
        return modelAndView;
    }
}
