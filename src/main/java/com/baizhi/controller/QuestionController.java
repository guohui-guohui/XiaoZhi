package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.CommentService;
import com.baizhi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname QuestionController
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 10:24
 */

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService qs;
    @Autowired
    CommentService cs;

    @RequestMapping("/all")
    public  String showAll(HttpSession session,Attention a){
        List<Question> all = qs.ShowAllQuestion();
        session.setAttribute("list",all);

        //推荐
        List<Question> list = qs.showOneByTime();
        session.setAttribute("recommend",list);
        //关注
        User u = (User) session.getAttribute("user");
        int uid = u.getId();
        List<Question> att = qs.shoeAtt(uid);
        //收藏个数
        User user = (User) session.getAttribute("user");
        int user_id = user.getId();
        int status = 1;
        List<Star> stars = qs.listStar(user_id, status);
        int lon = stars.size();
        session.setAttribute("lon",lon);
        //关注个数
        List<Attention> atten = qs.listAtt(user_id, status);
        int attent = atten.size();
        session.setAttribute("attent",attent);

        session.setAttribute("attention",att);
        //热榜
        List<Question> hot = qs.showHot();
        session.setAttribute("hot",hot);


        return "main";
    }
    /*
    * 提问
    * */
    @RequestMapping("/add")
    public String addQuestion(Question question){

        //发表时间 时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取日期
        Date date = new Date();
        String time = simpleDateFormat.format(date);

        question.setPublicsh_time(time);

        qs.addQuestion(question);
        return "redirect:/question/all";
    }
    /*
    * 搜索
    * */
    @RequestMapping("/query")
    public String queryQuestionByTitle(Question question,HttpSession session){
        List<Question> list = qs.queryQuestionByTitle(question);
        session.setAttribute("query",list);
        return "commen";
    }
    /*
    *点击标题内容
    * */
    @RequestMapping("/showTitle")
    public String showTitle(Question question,HttpSession session){
        List<Question> q = qs.showOneById(question);
        session.setAttribute("query",q);
        //关注按钮
        User user = (User) session.getAttribute("user");
        int user_id =user.getId();
        int question_id =question.getId();

        return "commen";
    }


    /*
    * 关注按钮
    * */
    @RequestMapping("/att")
    @ResponseBody
    public  List<Attention> att(int question_id,int user_id,HttpSession session){
        //添加关注
        List<Attention> lst = qs.queryByUIDAttention(question_id, user_id);

        //关注个数
        int status = 1;
        List<Attention> atten = qs.listAtt(user_id, status);
        int attent = atten.size();
        session.setAttribute("attent",attent);
        return lst;
    }

    /*
    * 点赞 */
    @RequestMapping("/upcount")
    @ResponseBody
    public Question thumbs_up(int id,int q_count){

        Question question = qs.addCount(id, q_count);
        return question;
    }
    /*
    * 收藏
    * */
    @RequestMapping("star")
    @ResponseBody
    public Star star(int user_id, int question_id,HttpSession session){
        Star star =qs.addStar(user_id,question_id);
        //收藏个数
        int status = 1;
        List<Star> stars = qs.listStar(user_id, status);
        int lon = stars.size();
        session.setAttribute("lon",lon);
        return star;
    }
}
