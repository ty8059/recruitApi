package com.admn.console.service;

import com.admn.common.Layui;
import com.admn.common.Page;

public interface PositionService {
    Layui getByPositionName(String positionName, Page page);
}
