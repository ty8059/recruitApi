package com.admn.web.service.impl;

import com.admn.web.dao.TblResumeMapper;
import com.admn.web.model.TblResume;
import com.admn.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private TblResumeMapper resumeMapper;

    @Override
    public List<TblResume> findResumeByUserId(Integer userId) {
        return resumeMapper.findByUserId(userId);
    }
}
