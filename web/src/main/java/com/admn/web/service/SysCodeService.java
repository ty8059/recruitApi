package com.admn.web.service;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblSysCode;

public interface SysCodeService {
    TblSysCode findByTypeCode(String typeCode);

    ResultEntity addSysCode(TblSysCode sysCode);
}
