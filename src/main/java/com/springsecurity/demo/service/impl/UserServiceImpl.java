package com.springsecurity.demo.service.impl;

import com.springsecurity.demo.mapper.UserMapper;
import com.springsecurity.demo.model.SysUser;
import com.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public boolean addUser(SysUser user)
    {
        encryptPassword(user);
        return userMapper.addUser(user);
    }
    public boolean deleteUser(int id)
    {
        return userMapper.deleteUser(id);
    }
    public SysUser getUserById(int id)
    {
        return userMapper.getUserById(id);
    }
    public List<SysUser> getUserList(int page, int number)
    {
        return userMapper.getUserList((page - 1)*number, number);
    }

    public boolean modifyUser(SysUser user)
    {
        return userMapper.modifyUser(user);
    }

    private void encryptPassword(SysUser user)
    {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }
}
