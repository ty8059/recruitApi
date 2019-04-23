package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;
import com.admn.common.ResultEntity;
import com.admn.console.model.TblPosition;

public interface PositionService {
    TblPosition getByPositionId(Integer positionId);

    Layui getByPositionName(String positionName, Page page);

    ResultEntity addPosition(TblPosition position);

    ResultEntity editPosition(TblPosition position);
}
