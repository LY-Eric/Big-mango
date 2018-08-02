package com.eric.education.service;

import com.eric.education.model.User;

/**
 * @author Eric
 * @create 2018-06-16 下午12:27
 * @desc
 */
public interface IUserService {

    /**
     * 用户添加
     */
    Boolean addUser(User user);

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    User queryUserByOpenId(String openid);
}
