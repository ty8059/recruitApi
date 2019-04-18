package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.dao.TblEduExpMapper;
import com.admn.console.dao.TblResumeMapper;
import com.admn.console.dao.TblWorkExpMapper;
import com.admn.console.model.TblEduExp;
import com.admn.console.model.TblResume;
import com.admn.console.model.TblWorkExp;
import com.admn.console.service.ResumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author wangyi
 * @Description 简历实现
 * @Date 2019/4/16 23:11
 * @Version 1.0
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private TblResumeMapper resumeMapper;
    @Autowired
    private TblWorkExpMapper workExpMapper;
    @Autowired
    private TblEduExpMapper eduExpMapper;

    @Override
    public Layui getResumeByResumeAndPage(String position, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblResume> list = resumeMapper.findByPosition(position);
        PageInfo<TblResume> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "resumeList");
    }

    @Override
    public TblResume getResumeByResumeId(Integer resumeId) {
        return resumeMapper.findByResumeId(resumeId);
    }

    @Override
    public TblEduExp getEduExpByUserId(Integer userId) {
        return eduExpMapper.findEduExpByUserId(userId);
    }

    @Override
    public TblWorkExp getWorkExpByUserId(Integer userId) {
        return workExpMapper.findWorkExpByUserId(userId);
    }

    @Override
    public ResultEntity invite(Integer resumeId, String status) {
        Example example = new Example(TblResume.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("resumeId", resumeId);
        TblResume resume = new TblResume();
        resume.setResumeId(resumeId);
        resume.setReserved2(status);
        int result = resumeMapper.updateByExampleSelective(resume, example);
        if (result > 0) {
            return new ResultEntity(true, "处理成功");
        } else {
            return new ResultEntity(false, "处理失败");
        }
    }

}
