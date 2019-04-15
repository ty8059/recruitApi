package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.console.dao.TblPositionMapper;
import com.admn.console.model.TblPosition;
import com.admn.console.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private TblPositionMapper positionMapper;

    @Override
    public Layui getByPositionName(String positionName, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblPosition> list = positionMapper.findByPositionName(positionName);
        PageInfo<TblPosition> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "positionList");
    }
}
