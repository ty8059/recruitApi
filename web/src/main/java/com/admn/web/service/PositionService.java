package com.admn.web.service;

import com.admn.web.model.TblPosition;

import java.util.List;

public interface PositionService {
    List<TblPosition> getPositionList();

    TblPosition getPositionById(Integer positionId);
}
