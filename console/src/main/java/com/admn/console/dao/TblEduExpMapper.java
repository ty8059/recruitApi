package com.admn.console.dao;

import com.admn.console.model.TblEduExp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TblEduExpMapper extends Mapper<TblEduExp> {
    @Override
    int insert(TblEduExp record);

    @Override
    int insertSelective(TblEduExp record);

    @Select("select t1.* from TBL_EDU_EXP t1 where t1.USER_ID = #{userId}")
    TblEduExp findEduExpByUserId(@Param("userId") Integer userId);
}