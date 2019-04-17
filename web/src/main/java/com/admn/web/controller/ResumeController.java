package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.common.ResultUtil;
import com.admn.web.model.TblEduExp;
import com.admn.web.model.TblResume;
import com.admn.web.model.TblWorkExp;
import com.admn.web.service.ResumeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PostMapping("getEduExpByUserId")
    @ResponseBody
    public ResultEntity getEduExpByUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            return new ResultEntity(false, "userId非法");
        }
        TblEduExp eduExp = resumeService.findEduExp(userId);
        if (eduExp != null) {
            return new ResultEntity(true, "获取resume成功", eduExp);
        } else {
            return new ResultEntity(true, "该用户无教育经验");
        }
    }

    @PostMapping("getWorkExpByUserId")
    @ResponseBody
    public ResultEntity getWorkExpByUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            return new ResultEntity(false, "userId非法");
        }
        TblWorkExp workExp = resumeService.findWorkExp(userId);
        if (workExp != null) {
            return new ResultEntity(true, "获取resume成功", workExp);
        } else {
            return new ResultEntity(true, "该用户无工作经验");
        }
    }

    @PostMapping("editBasicInfo")
    @ResponseBody
    public ResultEntity editBasicInfo(TblResume resume) {
        if (resume.getUserId() == null || resume.getUserId() <= 0) {
            return new ResultEntity(false, "userId为空或非法");
        }
        if (StringUtils.isBlank(resume.getRealName())) {
            return new ResultEntity(false, "姓名不能为空");
        }
        if (StringUtils.isBlank(resume.getSex())) {
            return new ResultEntity(false, "性别不能为空");
        }
        if (StringUtils.isBlank(resume.getBirthday())) {
            return new ResultEntity(false, "出生日期不能为空");
        }
        if (StringUtils.isBlank(resume.getUserPhone())) {
            return new ResultEntity(false, "手机号不能为空");
        }
        if (StringUtils.isBlank(resume.getAddress())) {
            return new ResultEntity(false, "地址不能为空");
        }
        if (StringUtils.isBlank(resume.getMarriage())) {
            return new ResultEntity(false, "婚姻情况不能为空");
        }
        if (StringUtils.isBlank(resume.getReserved1())) {
            return new ResultEntity(false, "邮箱不能为空");
        }
        return resumeService.editBasicInfo(resume);
    }

    @PostMapping("editEduExp")
    @ResponseBody
    public ResultEntity editEduExp(@Valid TblEduExp eduExp, BindingResult bindingResult) {
        if (eduExp.getUserId() == null || eduExp.getUserId() <= 0) {
            return new ResultEntity(false, "userId为空或非法");
        }
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return validResult;
        }
        return resumeService.editEduExp(eduExp);
    }

    @PostMapping("editWorkExp")
    @ResponseBody
    public ResultEntity editWorkExp(@Valid TblWorkExp workExp, BindingResult bindingResult) {
        if (workExp.getUserId() == null || workExp.getUserId() <= 0) {
            return new ResultEntity(false, "userId为空或非法");
        }
        ResultEntity validResult = ResultUtil.validModel(bindingResult);
        if (!validResult.isSuccess()) {
            return validResult;
        }
        return resumeService.editWorkExp(workExp);
    }
}
