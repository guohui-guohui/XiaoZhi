package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @Classname UserController
 * @Author GuOHuI
 * @Date 2020/11/19
 * @Time 21:17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    /*
    * 登录
    * */
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User u = us.findUser(user);
        //判断用户是否存在
        if(u == null){//不存在
            session.setAttribute("mesg","用户名已被注册或不存在");
            return "login";
        }else{//存在
            //密码不为空
            if(!user.getPassword().equals("")) {
                //判断密码是否正确
                if (!u.getPassword().equals(user.getPassword())) {//不正确
                    session.setAttribute("mesg", "密码错误，请重试");
                    return "login";
                }else{//正确
                    session.setAttribute("user",u);
                    return "redirect:/question/all";
                }
            }else{
                //密码为空
                session.setAttribute("mesg","请输入密码");
                return "login";
            }
        }
    }

    /*
    * 注册
    * */
    @RequestMapping("/register")
    public String register(MultipartFile file,User user, HttpSession session) throws IOException {
        //头像图片
        String fileName = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath + "/" + fileName);

        //判断用户名是否被注册
        User u = us.findUser(user);
        if(u != null){//用户已经存在
            session.setAttribute("mesg","用户信息已存在，请重新输入");
            return "register";
        }else{//成功注册用户
            if(!file1.exists()) {//判断图片是否存有
                file.transferTo(file1);
                user.setPhoto(fileName);

                us.addUser(user);
                return "login";
            }else {
                us.addUser(user);
                return "login";
            }
        }
    }

    /*
    * 更改用户信息
    * */
    @RequestMapping("/findPassword")
    public String findPassword(User user,HttpSession session,MultipartFile file) throws IOException {
        User users = us.findUser(user);

        //头像图片
        String fileName = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath + "/" + fileName);

        if(users != null){
            if(!file1.exists()) {//判断图片是否存有
                file.transferTo(file1);
                user.setPhoto(fileName);

                us.changeUserPassword(user);
                return "login";
            }else {
                user.setPhoto(fileName);
                us.changeUserPassword(user);
                return "login";
            }
        }else {
            session.setAttribute("mesg","请检查重新输入或选择注册");
            return "findPassword";
        }
    }

    //退出登录
    @RequestMapping("Exct")
    public String ExctUser(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "login";
    }
}
