package com.baizhi.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Reply
 * @Author GuOHuI
 * @Date 2020/11/24
 * @Time 8:41
 */
@Data
@Component
public class Reply implements Serializable {
    //评论回复表
    private int id;//id编号
    private String reply_common;//回复内容
    private int common_id;//回复的评论id
    private int question_id;//回复的问题id
    private int user_id;//用户id
    private String reply_time;//时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReply_common() {
        return reply_common;
    }

    public void setReply_common(String reply_common) {
        this.reply_common = reply_common;
    }

    public int getCommon_id() {
        return common_id;
    }

    public void setCommon_id(int common_id) {
        this.common_id = common_id;
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

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", reply_common='" + reply_common + '\'' +
                ", common_id=" + common_id +
                ", question_id=" + question_id +
                ", user_id=" + user_id +
                ", reply_time='" + reply_time + '\'' +
                '}';
    }

    public Reply(int id, String reply_common, int common_id, int question_id, int user_id, String reply_time) {
        this.id = id;
        this.reply_common = reply_common;
        this.common_id = common_id;
        this.question_id = question_id;
        this.user_id = user_id;
        this.reply_time = reply_time;
    }

    public Reply() {
    }
}
