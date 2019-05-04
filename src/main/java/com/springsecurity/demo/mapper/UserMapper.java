package com.springsecurity.demo.mapper;

import com.springsecurity.demo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    SysUser findByUserName(@Param("username") String username);

}
