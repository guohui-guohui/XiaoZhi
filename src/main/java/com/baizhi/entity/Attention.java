package com.baizhi.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Attention
 * @Author GuOHuI
 * @Date 2020/11/22
 * @Time 19:03
 */
@Data
@Component
public class Attention implements Serializable {
    /*关注*/
    private int id;//id
    private int user_id;//用户id
    private int question_id;//问题id
    private int status;//状态
    private String atime;//关注时间

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

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    @Override
    public String toString() {
        return "Attention{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", question_id=" + question_id +
                ", status=" + status +
                ", atime='" + atime + '\'' +
                '}';
    }

    public Attention(int id, int user_id, int question_id, int status, String atime) {
        this.id = id;
        this.user_id = user_id;
        this.question_id = question_id;
        this.status = status;
        this.atime = atime;
    }

    public Attention() {
    }
}
