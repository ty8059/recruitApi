package com.admn.web.dao;

import com.admn.web.model.TblPositionApp;
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