package com.admn.console.dao;

import com.admn.console.model.TblSysCode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TblSysCodeMapper {
    int insert(TblSysCode record);

    int insertSelective(TblSysCode record);

    @Select("select t1.* from TBL_SYS_CODE t1 where t1.TYPE_CODE = #{typeCode}")
    TblSysCode findByTypeCode(@Param("typeCode") String typeCode);

    List<TblSysCode> findLikeTypeCode(@Param("typeCode") String typeCode);
}