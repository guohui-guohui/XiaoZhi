package com.baizhi.controller;

import com.baizhi.entity.Common;
import com.baizhi.entity.User;
import com.baizhi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Classname CommentController
 * @Author GuOHuI
 * @Date 2020/11/24
 * @Time 9:51
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService cs;
/*
    @RequestMapping("/ajaxAddComm")
    @ResponseBody
    public String ajaxAddComm(Common c, HttpSession session){

        List<Common> commons = cs.showComment(c);
        List<Common> common = cs.showCommentCount(c);
        int co =commons.size();
        int cos =common.size();//评论个数
        int id =c.getQuestion_id();
        cs.queryQuestionChangeCountById(id,cos);

        session.setAttribute("co",co);
        session.setAttribute("common",commons);

        return "ok";
    }*/

    @RequestMapping("/addComm")
    public String addComm(Common c, HttpSession session){
        //String common_describe = c.getCommon_describe();
        //System.out.println(common_describe);
        if(c.getCommon_describe() != null && !c.getCommon_describe().equals("")) {
            cs.addComment(c);
        }
        List<Common> commons = cs.showComment(c);
        List<Common> common = cs.showCommentCount(c);
        int co =commons.size();
        int cos =common.size();//评论个数
        int id =c.getQuestion_id();
        cs.queryQuestionChangeCountById(id,cos);



        session.setAttribute("co",co);
        session.setAttribute("common",commons);

        return "redirect:/comment/allCommon";
    }
    @RequestMapping("/allCommon")
    public String allCommon(HttpSession session){
        //评论个数

        /*List<Common> commons = cs.showCommentCount();
        int co =commons.size();

        session.setAttribute("co",co);
       */


        return "redirect:/question/all";
    }
    @RequestMapping("/ccount")
    @ResponseBody
    public Common upCount(int id,int c_count,HttpSession session){
        Common common = cs.queryCommentCount(id,c_count);

        User u =cs.queryCommentUser(id);
        session.setAttribute("u",u);

        return common;
    }
}
