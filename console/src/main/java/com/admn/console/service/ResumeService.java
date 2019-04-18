package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblEduExp;
import com.admn.console.model.TblResume;
import com.admn.console.model.TblWorkExp;

/**
 * @Author wangyi
 * @Description 简历
 * @Date 2019/4/16 23:10
 * @Version 1.0
 */
public interface ResumeService {
    Layui getResumeByResumeAndPage(String position, Page page);

    TblResume getResumeByResumeId(Integer resumeId);

    TblEduExp getEduExpByUserId(Integer userId);

    TblWorkExp getWorkExpByUserId(Integer userId);

    ResultEntity invite(Integer resumeId, String status);
}
