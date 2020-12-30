package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * @Classname UserService
 * @Author GuOHuI
 * @Date 2020/11/19
 * @Time 21:19
 */
public interface UserService {
    User findUser(User user);

    void addUser(User user);

    List<User> changeUser(User user);

    void changeUserPassword(User user);
}
