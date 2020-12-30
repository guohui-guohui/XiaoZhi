package com.baizhi.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Star
 * @Author GuOHuI
 * @Date 2020/11/23
 * @Time 19:48
 */
@Data
@Component
public class Star implements Serializable {
    //收藏表
    private int id;
    private int user_id;
    private int question_id;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", question_id=" + question_id +
                ", status=" + status +
                '}';
    }

    public Star(int id, int user_id, int question_id, int status) {
        this.id = id;
        this.user_id = user_id;
        this.question_id = question_id;
        this.status = status;
    }

    public Star() {
    }
}
