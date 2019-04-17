package com.admn.web.service.impl;

import com.admn.common.ResultEntity;
import com.admn.web.dao.TblEduExpMapper;
import com.admn.web.dao.TblResumeMapper;
import com.admn.web.dao.TblWorkExpMapper;
import com.admn.web.model.TblEduExp;
import com.admn.web.model.TblResume;
import com.admn.web.model.TblWorkExp;
import com.admn.web.service.ResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Autowired
    private TblResumeMapper resumeMapper;
    @Autowired
    private TblEduExpMapper eduExpMapper;
    @Autowired
    private TblWorkExpMapper workExpMapper;

    @Override
    public List<TblResume> findResumeByUserId(Integer userId) {
        return resumeMapper.findByUserId(userId);
    }

    @Override
    public TblEduExp findEduExp(Integer userId) {
        List<TblEduExp> list = eduExpMapper.findByUserId(userId);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public TblWorkExp findWorkExp(Integer userId) {
        return workExpMapper.findByUserId(userId);
    }


    @Override
    public ResultEntity getInviteMsg(Integer userId) {
        List<TblResume> list = resumeMapper.findByUserId(userId);
        if (list.size() != 0) {
            TblResume resume = list.get(0);
            if ("00".equals(resume.getReserved2())) {
                return new ResultEntity(true, "HR主动邀请你参加面试，请联系HR");
            }
        }
        return new ResultEntity(false, "无面试邀请");
    }

    @Override
    public ResultEntity editBasicInfo(TblResume resume) {
        try {
            if (resumeMapper.findByUserId(resume.getUserId()).size() == 0) {
                resumeMapper.insertSelective(resume);
            } else {
                Example example = new Example(TblResume.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("userId", resume.getUserId());
                resumeMapper.updateByExampleSelective(resume, example);
            }
        } catch (Exception e) {
            LOGGER.error(">>ResumeServiceImpl, 更新简历失败", e);
            return new ResultEntity(false, "修改基本信息失败");
        }
        return new ResultEntity(true, "修改基本信息成功");
    }

    @Override
    public ResultEntity editEduExp(TblEduExp eduExp) {
        try {
            if (eduExpMapper.findByUserId(eduExp.getUserId()).size() == 0) {
                eduExpMapper.insertSelective(eduExp);
            } else {
                Example example = new Example(TblEduExp.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("userId", eduExp.getUserId());
                eduExpMapper.updateByExampleSelective(eduExp, example);
            }
        } catch (Exception e) {
            LOGGER.error(">>ResumeServiceImpl, 更新简历失败", e);
            return new ResultEntity(false, "修改教育经历失败");
        }
        return new ResultEntity(true, "修改教育经历成功");
    }

    @Override
    public ResultEntity editWorkExp(TblWorkExp workExp) {
        try {
            if (workExpMapper.findByUserId(workExp.getUserId()) == null) {
                workExpMapper.insertSelective(workExp);
            } else {
                Example example = new Example(TblWorkExp.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("userId", workExp.getUserId());
                workExpMapper.updateByExampleSelective(workExp, example);
            }
        } catch (Exception e) {
            LOGGER.error(">>ResumeServiceImpl, 更新简历失败", e);
            return new ResultEntity(false, "修改工作经历失败");
        }
        return new ResultEntity(true, "修改工作经历成功");
    }
}
