package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.console.dao.TblPositionAppMapper;
import com.admn.console.model.TblPositionApp;
import com.admn.console.service.PositionAppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionAppServiceImpl implements PositionAppService {

    @Autowired
    private TblPositionAppMapper positionAppMapper;

    @Override
    public Layui getAppByAppTimeAndStatus(String startTime, String endTime, String status, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblPositionApp> list = positionAppMapper.findAppByAppTimeAndStatus(startTime, endTime, status);
        PageInfo<TblPositionApp> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "positionAppList");
    }
}
