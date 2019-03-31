package com.admn.web.controller;

import com.admn.common.ResultEntity;
import com.admn.web.model.TblSysCode;
import com.admn.web.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysCodeController {

    @Autowired
    private SysCodeService sysCodeService;

    @RequestMapping("getSysCode")
    public ResultEntity getSysCode(String typeCode) {
        if (typeCode == null || "".equals(typeCode)) {
            return new ResultEntity(false, "typeCode不能为空");
        }
        TblSysCode sysCode = sysCodeService.findByTypeCode(typeCode);
        if (sysCode == null) {
            return new ResultEntity(false, "无此系统参数");
        }
        return new ResultEntity(true, "获取系统参数成功", sysCode);

    }
}
