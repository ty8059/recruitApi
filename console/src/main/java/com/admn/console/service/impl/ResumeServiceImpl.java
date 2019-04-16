package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.console.dao.TblResumeMapper;
import com.admn.console.model.TblResume;
import com.admn.console.service.ResumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Layui getResumeByResumeAndPage(String position, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblResume> list = resumeMapper.findByPosition(position);
        PageInfo<TblResume> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "resumeList");
    }

}
