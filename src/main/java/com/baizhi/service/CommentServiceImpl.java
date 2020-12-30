package com.baizhi.service;

import com.baizhi.dao.CommentDao;
import com.baizhi.entity.Common;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname CommentServiceImpl
 * @Author GuOHuI
 * @Date 2020/11/24
 * @Time 8:50
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao cd;

    @Override
    public List<Common> showComment(Common c) {
        List<Common> list = cd.queryAllComment(c);
        return list;
    }

    @Override
    public User queryCommentUser(int id) {
        User u = cd.queryCommentUser(id);
        return u;
    }

    @Override
    public void addComment(Common c) {
        //发表时间 时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取日期
        Date date = new Date();
        String common_time = simpleDateFormat.format(date);
        c.setCommon_time(common_time);
        cd.addOneComment(c);
    }

    @Override
    public List<Common> showCommentCount(Common c) {
        List<Common> list = cd.queryAllCommentCount(c);
        return list;
    }

    @Override
    public void queryQuestionChangeCountById(int id, int cos) {
        cd.queryQuestionByIdChangeNum(id,cos);
    }

    @Override
    public Common queryCommentCount(int id, int c_count) {
        Common common = cd.queryById(id);
        int count = common.getC_count();
        c_count = count + 1;
        cd.dianzan(id,c_count);

        Common q =cd.queryById(id);
        return q;
    }
}
