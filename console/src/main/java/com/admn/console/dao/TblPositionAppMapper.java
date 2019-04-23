package com.admn.console.dao;

import com.admn.console.model.TblPositionApp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblPositionAppMapper extends Mapper<TblPositionApp> {
    int insert(TblPositionApp record);

    int insertSelective(TblPositionApp record);

    @Select("select t1.* from TBL_POSITION_APP t1 where t1.USER_ID = #{userId} and t1.POSITION_ID = #{positionId} and t1.RESUME_ID = #{resumeId}")
    TblPositionApp findAppByUserId(@Param("userId") Integer userId, Integer positionId, Integer resumeId);

    List<TblPositionApp> findAppByAppTimeAndStatus(@Param("startTime") String startTime,
                                                   @Param("endTime") String endTime,
                                                   @Param("status") String status);
}