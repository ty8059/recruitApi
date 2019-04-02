package com.admn.web.service.impl;

import com.admn.common.ResultEntity;
import com.admn.web.dao.TblResumeMapper;
import com.admn.web.model.TblResume;
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

    @Override
    public List<TblResume> findResumeByUserId(Integer userId) {
        return resumeMapper.findByUserId(userId);
    }

    @Override
    public ResultEntity editResume(TblResume resume) {
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
            return new ResultEntity(false, "修改失败");
        }
        return new ResultEntity(true, "修改成功");
    }
}
