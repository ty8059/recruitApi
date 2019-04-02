package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblResume;
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

    @PostMapping("editResume")
    @ResponseBody
    public ResultEntity editResume(TblResume resume) {
        if (resume.getUserId() == null || resume.getUserId() <= 0) {
            return new ResultEntity(false, "userId为空或非法");
        }
        if (resume.getRealName() == null || "".equals(resume.getRealName())) {
            return new ResultEntity(false, "姓名不能为空");
        }
        if (resume.getSex() == null || "".equals(resume.getSex())) {
            return new ResultEntity(false, "性别不能为空");
        }
        if (resume.getBirthday() == null || "".equals(resume.getBirthday())) {
            return new ResultEntity(false, "出生日期不能为空");
        }
        if (resume.getUserPhone() == null || "".equals(resume.getUserPhone())) {
            return new ResultEntity(false, "手机号不能为空");
        }
        if (resume.getAddress() == null || "".equals(resume.getAddress())) {
            return new ResultEntity(false, "地址不能为空");
        }
        if (resume.getMarriage() == null || "".equals(resume.getMarriage())) {
            return new ResultEntity(false, "婚姻情况不能为空");
        }
        return resumeService.editResume(resume);
    }
}
