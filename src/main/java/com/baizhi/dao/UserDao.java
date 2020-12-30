package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Author GuOHuI
 * @Date 2020/11/19
 * @Time 21:15
 */
public interface UserDao {

    User queryUser(User user);

    void addUser(User user);

    List<User> queryUserPhone(String phone);

    List<User> queryUserEmail(String email);

    List<User> queryUserName(String name);

    void changePasswordByName(User user);
}
