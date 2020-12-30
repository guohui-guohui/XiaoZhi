package com.baizhi.service;

import com.baizhi.dao.QuestionDao;
import com.baizhi.entity.Attention;
import com.baizhi.entity.Question;
import com.baizhi.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname QuestionServiceImpl
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 10:23
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao qd;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Question> ShowAllQuestion() {
        List<Question> list = qd.queryAll();
        return list;
    }

    @Override
    public void addQuestion(Question question) {
        qd.addQuestion(question);

    }

    @Override
    public List<Question> queryQuestionByTitle(Question question) {
        List<Question> list =qd.queryQuestion(question);
        return list;
    }

    @Override
    public List<Question> showOneByTime() {
        List<Question> list = qd.queryOneByTime();
        return list;
    }

    @Override
    public  List<Question> showOneById(Question question) {
        List<Question> q = qd.queryOneById(question);
        return q;
    }

    @Override
    public List<Question> showHot() {
        List<Question> q = qd.queryHot();
        return q;
    }

    @Override
    public  List<Question> shoeAtt(int uid) {
        List<Question> list = qd.queryAtt(uid);
        return list;
    }

    @Override
    public void addAttention(int question_id, int user_id) {
        //发表时间 时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取日期
        Date date = new Date();
        String atime = simpleDateFormat.format(date);

        qd.addAttention(question_id,user_id,atime);
    }

    @Override
    public List<Attention> queryByUIDAttention(int question_id, int user_id) {
        List<Attention> list = qd.queryByUID(question_id,user_id);
        if(list.isEmpty()){//集合不为空  list.size() == 0
            //发表时间 时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取日期
            Date date = new Date();
            String atime = simpleDateFormat.format(date);

            qd.addAttention(question_id,user_id,atime);
        }

        return list;
    }

    @Override
    public Question addCount(int id, int q_count) {
        Question question = qd.queryById(id);
        int count = question.getQ_count();
        q_count = count + 1;
        qd.dianzan(id,q_count);

        Question q =qd.queryById(id);
        return q;
    }

    @Override
    public Star addStar(int user_id, int question_id) {
        Star star = qd.queryStar(user_id,question_id);
        if(star == null){
            int status = 1;//表示收藏
            qd.addStar(user_id,question_id,status);

            Star r =qd.queryStar(user_id,question_id);
            return r;
        }else{
            return star;
        }

    }

    @Override
    public List<Star> listStar(int user_id, int status) {
        //收藏个数
        List<Star> list = qd.queryListStar(user_id,status);
        return list;
    }

    @Override
    public List<Attention> listAtt(int user_id, int status) {
        List<Attention> list = qd.queryListAtt(user_id,status);
        return list;
    }


}
