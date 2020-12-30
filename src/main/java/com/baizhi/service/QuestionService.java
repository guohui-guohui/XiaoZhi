package com.baizhi.service;

import com.baizhi.entity.Attention;
import com.baizhi.entity.Question;
import com.baizhi.entity.Star;

import java.util.List;

/**
 * @Classname QuestionService
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 10:22
 */
public interface QuestionService {
    List<Question> ShowAllQuestion();

    void addQuestion(Question question);

    List<Question> queryQuestionByTitle(Question question);

    List<Question> showOneByTime();

    List<Question> showOneById(Question question);

    List<Question> showHot();

    List<Question> shoeAtt(int uid);

    void addAttention(int question_id, int user_id);

    List<Attention> queryByUIDAttention(int question_id, int user_id);

    Question addCount(int id, int q_count);

    Star addStar(int user_id, int question_id);

    List<Star> listStar(int user_id,int status);

    List<Attention> listAtt(int user_id, int status);
}
