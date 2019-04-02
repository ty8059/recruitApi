package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblResume;

import java.util.List;

public interface ResumeService {
    List<TblResume> findResumeByUserId(Integer userId);

    ResultEntity editResume(TblResume resume);
}
