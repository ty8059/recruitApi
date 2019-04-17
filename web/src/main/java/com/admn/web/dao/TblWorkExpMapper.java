package com.admn.web.dao;

import com.admn.web.model.TblWorkExp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TblWorkExpMapper extends Mapper<TblWorkExp> {
    @Override
    int insert(TblWorkExp record);

    @Override
    int insertSelective(TblWorkExp record);

    @Select("select t1.* from TBL_WORK_EXP t1 where t1.USER_ID = #{userId}")
    TblWorkExp findByUserId(@Param("userId") Integer userId);
}