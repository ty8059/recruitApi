package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblEduExp;
import com.admn.web.model.TblResume;

import java.util.List;

public interface ResumeService {
    List<TblResume> findResumeByUserId(Integer userId);

    TblEduExp findEduExp(Integer userId);

    ResultEntity editBasicInfo(TblResume resume);

    ResultEntity editEduExp(TblEduExp eduExp);
}
