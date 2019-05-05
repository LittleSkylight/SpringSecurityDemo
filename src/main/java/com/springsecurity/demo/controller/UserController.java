package com.springsecurity.demo.controller;

import com.springsecurity.demo.model.SysUser;
import com.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/doRegister")
    public boolean doRegister(SysUser user) {
        return userService.addUser(user);
    }
}