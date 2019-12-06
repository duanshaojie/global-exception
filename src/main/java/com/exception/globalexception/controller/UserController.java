package com.exception.globalexception.controller;

import com.exception.globalexception.model.ReturnResult;
import com.exception.globalexception.model.User;
import com.exception.globalexception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p><b>@name:</b> UserController.java</p>
 * <p><b>@title:</b> 用户</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 20点32分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("getUser")
    public ReturnResult getUser(Long id){
        User user = userService.findById(id);
        return ReturnResult.instance(true, user, null);
    }
}

