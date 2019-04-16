package com.admn.web.dao;

import com.admn.web.model.TblPosition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TblPositionMapper extends Mapper<TblPosition> {
    @Override
    int insert(TblPosition record);

    @Override
    int insertSelective(TblPosition record);

    @Select("select t1.* from TBL_POSITION t1 where t1.POSITION_ID = #{positionId}")
    TblPosition findPositionById(@Param("positionId") Integer positionId);
}