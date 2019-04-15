package com.admn.console.dao;

import com.admn.console.model.TblPositionApp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblPositionAppMapper extends Mapper<TblPositionApp> {
    int insert(TblPositionApp record);

    int insertSelective(TblPositionApp record);

    List<TblPositionApp> findAppByAppTimeAndStatus(@Param("startTime") String startTime,
                                                   @Param("endTime") String endTime,
                                                   @Param("status") String status);
}