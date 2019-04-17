package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblEduExp;
import com.admn.web.model.TblResume;
import com.admn.web.model.TblWorkExp;

import java.util.List;

public interface ResumeService {
    List<TblResume> findResumeByUserId(Integer userId);

    TblEduExp findEduExp(Integer userId);

    TblWorkExp findWorkExp(Integer userId);

    ResultEntity editBasicInfo(TblResume resume);

    ResultEntity editEduExp(TblEduExp eduExp);

    ResultEntity editWorkExp(TblWorkExp workExp);
}
