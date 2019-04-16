package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblSysCode;

public interface SysCodeService {
    TblSysCode findByTypeCode(String typeCode);

    Layui findBySysCodeAndPage(TblSysCode sysCode, Page page);

    ResultEntity addSysCode(TblSysCode sysCode);
}
