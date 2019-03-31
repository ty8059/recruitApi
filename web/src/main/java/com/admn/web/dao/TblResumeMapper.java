package com.admn.web.dao;

import com.admn.web.model.TblResume;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblResumeMapper extends Mapper<TblResume> {
    int insert(TblResume record);

    int insertSelective(TblResume record);

    @Select("select t1.* from TBL_RESUME t1 where t1.USER_ID = #{userId}")
    List<TblResume> findByUserId(@Param("userId") Integer userId);
}