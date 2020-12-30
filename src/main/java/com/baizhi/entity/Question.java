package com.baizhi.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Question
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 10:07
 */
@Data
@Component
public class Question implements Serializable {
    //问题表
    private int id;//问题id
    private String question_title;//问题内容
    private String publicsh_time;//发表时间
    private int q_count;//点赞个数
    private int p_num;//评论总数
    private int user_id;//用户id
    private int cang_id;//收藏id  0--未收藏 1--收藏

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getPublicsh_time() {
        return publicsh_time;
    }

    public void setPublicsh_time(String publicsh_time) {
        this.publicsh_time = publicsh_time;
    }

    public int getQ_count() {
        return q_count;
    }

    public void setQ_count(int q_count) {
        this.q_count = q_count;
    }

    public int getP_num() {
        return p_num;
    }

    public void setP_num(int p_num) {
        this.p_num = p_num;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCang_id() {
        return cang_id;
    }

    public void setCang_id(int cang_id) {
        this.cang_id = cang_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question_title='" + question_title + '\'' +
                ", publicsh_time='" + publicsh_time + '\'' +
                ", q_count=" + q_count +
                ", p_num=" + p_num +
                ", user_id=" + user_id +
                ", cang_id=" + cang_id +
                '}';
    }

    public Question(int id, String question_title, String publicsh_time, int q_count, int p_num, int user_id, int cang_id) {
        this.id = id;
        this.question_title = question_title;
        this.publicsh_time = publicsh_time;
        this.q_count = q_count;
        this.p_num = p_num;
        this.user_id = user_id;
        this.cang_id = cang_id;
    }

    public Question() {
    }
}
