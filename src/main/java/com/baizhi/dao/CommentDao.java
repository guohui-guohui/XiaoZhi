package com.baizhi.dao;

import com.baizhi.entity.Common;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CommentDao
 * @Author GuOHuI
 * @Date 2020/11/24
 * @Time 8:48
 */
public interface CommentDao {
    List<Common> queryAllComment(Common c);
    User queryCommentUser(int id);

    void addOneComment(Common c);

    List<Common> queryAllCommentCount(Common c);

    void queryQuestionByIdChangeNum(@Param("id") int id, @Param("cos") int cos);

    Common queryById(int id);

    void dianzan(int id, int c_count);
}
