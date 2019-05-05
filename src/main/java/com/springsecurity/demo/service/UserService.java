package com.springsecurity.demo.service;

import com.springsecurity.demo.model.SysUser;

import java.util.List;

public interface UserService {
    boolean addUser(SysUser user);
    boolean deleteUser(int id);
    SysUser getUserById(int id);
    List<SysUser> getUserList(int page,int number);

    boolean modifyUser(SysUser user);
}
