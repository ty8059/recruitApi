package com.admn.console.service.impl;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.dao.TblSysCodeMapper;
import com.admn.console.model.TblPositionApp;
import com.admn.console.model.TblSysCode;
import com.admn.console.service.SysCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    private TblSysCodeMapper sysCodeMapper;

    @Override
    public TblSysCode findByTypeCode(String typeCode) {
        return sysCodeMapper.findByTypeCode(typeCode);
    }

    @Override
    public Layui findBySysCodeAndPage(TblSysCode sysCode, Page page) {
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List<TblSysCode> list = sysCodeMapper.findLikeTypeCode(sysCode.getTypeCode());
        PageInfo<TblSysCode> pageInfo = new PageInfo<>(list);
        return Layui.data((int)pageInfo.getTotal(), list, "sysCodeList");
    }

    @Override
    public ResultEntity addSysCode(TblSysCode sysCode) {
        int result = sysCodeMapper.insertSelective(sysCode);
        if (result <= 0) {
            return new ResultEntity(false, "添加系统参数失败");
        } else {
            return new ResultEntity(true, "添加系统参数成功");
        }
    }
}
