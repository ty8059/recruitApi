package com.admn.console.dao;

import com.admn.console.model.TblResume;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblResumeMapper extends Mapper<TblResume> {
    @Override
    int insert(TblResume record);

    @Override
    int insertSelective(TblResume record);

    @Select("select t1.*, t2.DEGREE from TBL_RESUME t1 " +
            "left join TBL_EDU_EXP t2 on t1.USER_ID = t2.USER_ID " +
            "where t1.RESUME_ID = #{resumeId}")
    TblResume findByResumeId(@Param("resumeId") Integer resumeId);

    List<TblResume> findByPosition(@Param("position") String position);
}