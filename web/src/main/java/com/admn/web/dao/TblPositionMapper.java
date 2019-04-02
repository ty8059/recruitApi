package com.admn.web.dao;

import com.admn.web.model.TblPosition;
import tk.mybatis.mapper.common.Mapper;

public interface TblPositionMapper extends Mapper<TblPosition> {
    int insert(TblPosition record);

    int insertSelective(TblPosition record);
}