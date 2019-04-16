package com.admn.console.dao;

import com.admn.console.model.TblResume;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblResumeMapper extends Mapper<TblResume> {
    @Override
    int insert(TblResume record);

    @Override
    int insertSelective(TblResume record);

    List<TblResume> findByPosition(@Param("position") String position);
}