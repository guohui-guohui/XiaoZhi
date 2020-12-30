package com.baizhi.service;

import com.baizhi.entity.Common;
import com.baizhi.entity.User;

import java.util.List;

/**
 * @Classname CommentService
 * @Author GuOHuI
 * @Date 2020/11/24
 * @Time 8:50
 */
public interface CommentService {
    List<Common> showComment(Common c);

    User queryCommentUser(int id);

    void addComment(Common c);

    List<Common> showCommentCount(Common c);

    void queryQuestionChangeCountById(int id, int cos);

    Common queryCommentCount(int id, int c_count);
}
