package com.eric.education.service.impl;

import com.eric.education.dao.UserDao;
import com.eric.education.model.User;
import com.eric.education.model.UserQuery;
import com.eric.education.service.IUserService;
import com.eric.education.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author Eric
 * @create 2018-06-16 下午12:27
 * @desc
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean addUser(User user) {

        user.setUpdateTime(DateUtils.getNowTime());
        user.setCreateTime(DateUtils.getNowTime());
        try {
            userDao.insert(user);
            return true;
        } catch (Exception e) {
            System.out.println("add User Fail");
            return false;
        }
    }

    @Override
    public User queryUserByOpenId(String openid) {

        UserQuery query = new UserQuery();
        UserQuery.Criteria criteria = query.createCriteria();
        criteria.andOpenidEqualTo(openid);

        List<User> users = userDao.selectByExample(query);

        if (users != null && !users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}
