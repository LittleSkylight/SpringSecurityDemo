package com.springsecurity.demo.mapper;

import com.springsecurity.demo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    SysUser findByUserName(@Param("username") String username);


    boolean addUser(@Param("u") SysUser user);
    boolean deleteUser(@Param("id") int id);
    SysUser getUserById(@Param("id") int id);
    List<SysUser> getUserList(@Param("page") int page,@Param("number") int number);

    boolean modifyUser(@Param("u") SysUser user);
}
