package com.eric.education.service;

import com.eric.education.model.User;
import com.eric.education.request.UserRequest;
import com.eric.education.response.UserResponse;

/**
 * @author liuyang
 * @create 2018-05-30 15:33
 * @desc
 */
public interface IUserService {

    /**
     * 查询用户对应的角色
     * @param userId
     * @return
     */
    UserResponse queryUserRole(String userId);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    UserResponse registerUser(User user);

    /**
     * 根据用户ID查询用户
     * @param openid
     * @return
     */
    Boolean queryUserByUserId(String openid);
}
