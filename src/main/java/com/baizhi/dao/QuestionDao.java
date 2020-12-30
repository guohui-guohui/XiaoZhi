package com.baizhi.dao;

import com.baizhi.entity.Attention;
import com.baizhi.entity.Question;
import com.baizhi.entity.Star;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname QuestionDao
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 10:21
 */
public interface QuestionDao {
    List<Question> queryAll();

    void addQuestion(Question question);

    List<Question> queryQuestion(Question question);

    List<Question> queryOneByTime();

    List<Question> queryOneById(Question question);

    List<Question> queryHot();

    List<Question> queryAtt(int uid);

    void addAttention(int question_id, int user_id,String atime);

    List<Attention> queryByUID(@Param("question_id")int question_id, @Param("user_id")int user_id);

    void dianzan(@Param("id")int id,@Param("q_count")int q_count);
    Question queryById(int id);

    Star queryStar(@Param("user_id") int user_id, @Param("question_id") int question_id);

    void addStar(@Param("user_id") int user_id, @Param("question_id") int question_id,@Param("status")int status);

    List<Star> queryListStar(@Param("user_id")int user_id,@Param("status")int status);

    List<Attention> queryListAtt(@Param("user_id")int user_id,@Param("status")int status);
}
