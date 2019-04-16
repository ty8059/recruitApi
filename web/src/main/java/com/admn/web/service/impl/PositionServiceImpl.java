package com.admn.web.service.impl;

import com.admn.web.dao.TblPositionMapper;
import com.admn.web.model.TblPosition;
import com.admn.web.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private TblPositionMapper positionMapper;

    @Override
    public List<TblPosition> getPositionList() {
        return positionMapper.selectAll();
    }

    @Override
    public TblPosition getPositionById(Integer positionId) {
        return positionMapper.findPositionById(positionId);
    }
}
