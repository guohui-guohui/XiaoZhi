package com.baizhi.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Common
 * @Author GuOHuI
 * @Date 2020/11/23
 * @Time 22:16
 */
@Data
@Component
public class Common implements Serializable {
    //问题评论表
    private int id;//id
    private String common_describe;//评论内容
    private int c_count;//点赞
    private int question_id;//评论问题的id
    private int user_id;//评论用户的id
    private String common_time;//评论时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommon_describe() {
        return common_describe;
    }

    public void setCommon_describe(String common_describe) {
        this.common_describe = common_describe;
    }

    public int getC_count() {
        return c_count;
    }

    public void setC_count(int c_count) {
        this.c_count = c_count;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCommon_time() {
        return common_time;
    }

    public void setCommon_time(String common_time) {
        this.common_time = common_time;
    }

    @Override
    public String toString() {
        return "Common{" +
                "id=" + id +
                ", common_describe='" + common_describe + '\'' +
                ", c_count=" + c_count +
                ", question_id=" + question_id +
                ", user_id=" + user_id +
                ", common_time='" + common_time + '\'' +
                '}';
    }

    public Common(int id, String common_describe, int c_count, int question_id, int user_id, String common_time) {
        this.id = id;
        this.common_describe = common_describe;
        this.c_count = c_count;
        this.question_id = question_id;
        this.user_id = user_id;
        this.common_time = common_time;
    }

    public Common() {
    }
}
