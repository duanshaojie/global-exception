package com.exception.globalexception.service;

import com.exception.globalexception.model.User;

/**
 * @author edison
 */
public interface UserService {

    User findById(Long id);
}
