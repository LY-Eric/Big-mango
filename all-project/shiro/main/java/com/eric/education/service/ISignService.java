package com.eric.education.service;

import com.eric.education.response.SignResponse;

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
    SignResponse signToday(String userId);

    /**
     * 查询本月昨日签到情况
     * @param userId
     * @return
     */
    SignResponse yesterdayDetail(String userId);

    /**
     * 获取连续签到次数
     * @param userId
     * @return
     */
    SignResponse signCalc(String userId);

    /**
     * 记录签到
     * @param userId
     */
    void addSignDetail(String userId);

    /**
     * 记录签到次数
     * @param userId
     */
    void addSignCalc(String userId);

    /**
     * 修改连续签到次数
     * @param userId
     */
    void updateSignCalc(String userId, Long times);
}
