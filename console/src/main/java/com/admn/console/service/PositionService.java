package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblPosition;

public interface PositionService {
    Layui getByPositionName(String positionName, Page page);

    ResultEntity addPosition(TblPosition position);
}
