package com.eric.education.service;


import com.eric.education.model.SignCalc;
import com.eric.education.model.SignDetail;

import java.util.List;

/**
 * @author liuyang
 * @create 2018-05-31 14:57
 * @desc
 */
public interface ISignService {

    /**
     * 查询用户今日的签到
     * @param userId
     * @return
     */
    List<SignDetail> signToday(Integer userId);

    /**
     * 查询本月昨日签到情况
     * @param userId
     * @return
     */
    List<SignDetail> yesterdayDetail(Integer userId);

    /**
     * 获取连续签到次数
     * @param userId
     * @return
     */
    List<SignCalc> signCalc(Integer userId);

    /**
     * 记录签到
     * @param userId
     */
    void addSignDetail(Integer userId);

    /**
     * 记录签到次数
     * @param userId
     */
    void addSignCalc(Integer userId);

    /**
     * 修改连续签到次数
     * @param userId
     */
    void updateSignCalc(Integer userId, Integer times);
}
