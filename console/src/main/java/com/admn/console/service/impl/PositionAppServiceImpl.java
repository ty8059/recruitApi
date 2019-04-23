package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.dao.TblPositionAppMapper;
import com.admn.console.model.TblPositionApp;
import com.admn.console.service.PositionAppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PositionAppServiceImpl implements PositionAppService {

    @Autowired
    private TblPositionAppMapper positionAppMapper;

    @Override
    public TblPositionApp getAppByUserIdAndPositionIdAndResumeId(Integer userId, Integer positionId, Integer resumeId) {
        return positionAppMapper.findAppByUserId(userId, positionId, resumeId);
    }

    @Override
    public Layui getAppByAppTimeAndStatus(String startTime, String endTime, String status, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblPositionApp> list = positionAppMapper.findAppByAppTimeAndStatus(startTime, endTime, status);
        PageInfo<TblPositionApp> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "positionAppList");
    }

    @Override
    public ResultEntity processApp(TblPositionApp positionApp) {
        Example example = new Example(TblPositionApp.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", positionApp.getUserId());
        criteria.andEqualTo("positionId", positionApp.getPositionId());
        criteria.andEqualTo("resumeId", positionApp.getResumeId());
        positionAppMapper.updateByExampleSelective(positionApp, example);
        return new ResultEntity(true, "修改成功");
    }
}
