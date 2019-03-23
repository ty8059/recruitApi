package com.admn.console.service;

import com.admn.common.ResultEntity;
import com.admn.console.model.TblSysCode;

public interface SysCodeService {
    TblSysCode findByTypeCode(String typeCode);

    ResultEntity addSysCode(TblSysCode sysCode);
}
