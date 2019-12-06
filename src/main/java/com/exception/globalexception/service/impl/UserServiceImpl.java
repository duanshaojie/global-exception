package com.exception.globalexception.service.impl;

import com.exception.globalexception.common.BusinessException;
import com.exception.globalexception.model.User;
import com.exception.globalexception.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * <p><b>@name:</b> UserServiceImpl.java</p>
 * <p><b>@title:</b> 用户相关</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 20点25分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String USERID_NULL = "查询ID不能为空";
    private static final String USER_NAME = "edison";

    @Override
    public User findById(Long id) {
        if (null == id) {
            throw new BusinessException(USERID_NULL);
        }
        return new User().setId(id).setName(USER_NAME);
    }
}
