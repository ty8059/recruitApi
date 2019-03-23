package com.admn.console.dao;

import com.admn.console.model.TblUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TblUserMapper extends Mapper<TblUser> {
    int insert(TblUser record);

    int insertSelective(TblUser record);

    @Select("select t1.* from TBL_USER t1 where t1.USER_ID = #{userId}")
    TblUser findUserById(@Param("userId") Integer userId);

    @Select("select t1.* from TBL_USER t1 where t1.USERNAME = #{username}")
    TblUser findUserByName(@Param("username") String username);
}