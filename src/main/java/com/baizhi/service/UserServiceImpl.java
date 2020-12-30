package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Author GuOHuI
 * @Date 2020/11/19
 * @Time 21:19
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao ud;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findUser(User user) {
        //判断登录条件是邮箱/手机号/用户名
       /* String phone = user.getPhone();
        String email = user.getEmail();
        String name = user.getName();

        //判断是邮箱还是手机号的正则表达式
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";

        if(phone.matches(ph)){//用户手机号登录
            User u = ud.queryUserPhone(phone);
            return u;
        }else if(email.matches(em)){//用户邮箱登录
            User u = ud.queryUserEmail(email);
            return u;
        }else{//用户进行用户名登录
            User u = ud.queryUserName(name);
            return u;
        }*/

       User u = ud.queryUser(user);
       return u;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user) {
        //检查用户是否存在
       /* User u = ud.queryUser(user);
        if( u != null){//用户存在
            return false;
        }else {*/
            ud.addUser(user);
           /* return true;
        }*/
    }

    @Override
    public List<User> changeUser(User user) {
        List<User> u = ud.queryUserEmail(user.getEmail());
        List<User> us = ud.queryUserName(user.getName());
        List<User> use = ud.queryUserPhone(user.getPhone());
        for(User u1 : us){
            for(User u2 :u){
                for(User u3:use){
                   /* System.out.println(u3);*/
                }
            }
        }

        if(u.equals(us.equals(use))){
            return us;
        }else {
            return null;
        }
    }

    @Override
    public void changeUserPassword(User user) {
        ud.changePasswordByName(user);
    }
}
