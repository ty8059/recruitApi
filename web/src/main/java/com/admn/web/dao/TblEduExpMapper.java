package com.admn.web.dao;

import com.admn.web.model.TblEduExp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TblEduExpMapper extends Mapper<TblEduExp> {
    int insert(TblEduExp record);

    int insertSelective(TblEduExp record);

    @Select("select t1.* from TBL_EDU_EXP t1 where t1.USER_ID = #{userId}")
    List<TblEduExp> findByUserId(@Param("userId") Integer userId);
}