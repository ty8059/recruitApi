package com.admn.console.controller;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.console.model.TblEduExp;
import com.admn.console.model.TblResume;
import com.admn.console.model.TblWorkExp;
import com.admn.console.service.ResumeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @Author wangyi
 * @Description 简历管理
 * @Date 2019/3/24 19:39
 * @Version 1.0
 */
@RestController
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/resume/resume");
        return modelAndView;
    }

    @GetMapping("resumeDetail")
    public ModelAndView resumeDetail(ModelAndView modelAndView, Integer resumeId) {
        modelAndView.setViewName("/resume/resumeDetail");
        if (resumeId == null) {
            modelAndView.addObject("errorMsg", "resumeId为空");
            return modelAndView;
        }
        TblResume resume = resumeService.getResumeByResumeId(resumeId);
        TblWorkExp workExp = resumeService.getWorkExpByUserId(resume.getUserId());
        TblEduExp eduExp = resumeService.getEduExpByUserId(resume.getUserId());
        if (workExp != null) {
            modelAndView.addObject("workExp", workExp);
        }
        if (eduExp != null) {
            modelAndView.addObject("eduExp", eduExp);
        }
        if (resume == null) {
            modelAndView.addObject("errorMsg", "该简历不存在");
        } else {
            modelAndView.addObject("resume", resume);
        }
        return modelAndView;
    }

    @RequestMapping("dataGrid")
    public Layui dataGrid(@Valid Page page, BindingResult bindingResult, String position) {
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return Layui.error(validResult.getMsg());
        }
        return resumeService.getResumeByResumeAndPage(position, page);
    }

    @PostMapping("invite")
    public ResultEntity invite(Integer resumeId, String status) {
        if (resumeId == null) {
            return new ResultEntity(false, "resumeId不能为空");
        }
        if (StringUtils.isBlank(status)) {
            return new ResultEntity(false, "处理status不能为空");
        }
        return resumeService.invite(resumeId, status);
    }

}
