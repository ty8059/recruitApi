package com.admn.web.service.impl;

import com.admn.common.ResultEntity;
import com.admn.web.dao.TblSysCodeMapper;
import com.admn.web.model.TblSysCode;
import com.admn.web.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    private TblSysCodeMapper sysCodeMapper;

    @Override
    public TblSysCode findByTypeCode(String typeCode) {
        return sysCodeMapper.findByTypeCode(typeCode);
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
