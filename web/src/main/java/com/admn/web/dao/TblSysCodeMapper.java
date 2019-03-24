package com.admn.web.dao;

import com.admn.web.model.TblSysCode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TblSysCodeMapper {
    int insert(TblSysCode record);

    int insertSelective(TblSysCode record);

    @Select("select t1.* from TBL_SYS_CODE t1 where t1.TYPE_CODE = #{typeCode}")
    TblSysCode findByTypeCode(@Param("typeCode") String typeCode);
}