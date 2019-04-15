package com.admn.console.dao;

import com.admn.console.model.TblPosition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblPositionMapper extends Mapper<TblPosition> {
    int insert(TblPosition record);

    int insertSelective(TblPosition record);

    List<TblPosition> findByPositionName(@Param("positionName") String positionName);
}