package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblResume;

/**
 * @Author wangyi
 * @Description 简历
 * @Date 2019/4/16 23:10
 * @Version 1.0
 */
public interface ResumeService {
    Layui getResumeByResumeAndPage(String position, Page page);

    TblResume getResumeByResumeId(Integer resumeId);

    ResultEntity invite(Integer resumeId, String status);
}
