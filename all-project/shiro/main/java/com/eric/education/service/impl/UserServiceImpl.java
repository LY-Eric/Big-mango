package com.eric.education.service.impl;

import com.eric.education.dao.UserDao;
import com.eric.education.dao.UserDaoExtend;
import com.eric.education.exception.ErrorConstants;
import com.eric.education.model.Role;
import com.eric.education.model.User;
import com.eric.education.response.UserResponse;
import com.eric.education.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liuyang
 * @create 2018-05-30 15:33
 * @desc
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDaoExtend userDaoExtend;

    @Override
    public UserResponse queryUserRole(String userId) {

        UserResponse userResponse = new UserResponse();

        List<Role> userList = userDaoExtend.queryUserRole(userId);

        Map<Long, String> map = new HashMap<>(16);
        userList.stream().forEach(role -> {
                map.put(role.getRoleId(),role.getRoleName());
                }
        );

        if (!map.isEmpty() && map != null){
            userResponse.setMap(map);
        }else {
            userResponse.setMap(new HashMap<>());
        }

        return userResponse;
    }

    @Override
    @Transactional
    public UserResponse registerUser(User user) {
        UserResponse userResponse = new UserResponse();

        user.setCreateTime(new Date());

        int flag = userDao.insert(user);

        if (user.getIdentity() != null && user.getIdentity() != ""){
            userDaoExtend.addRole(user.getUserId(), user.getIdentity());
        }

        if (flag > 0){
            return userResponse;
        }else {
            userResponse.setReturnCode(ErrorConstants.FAIL_CODE);
            userResponse.setReturnMsg("保存失败");
            return userResponse;
        }

    }

    @Override
    public Boolean queryUserByUserId(String openid) {

        User user = userDao.selectByPrimaryKey(openid);

        if (user != null){
            return true;
        }

        return false;
    }

}
