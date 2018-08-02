package com.eric.education.dao;


import com.eric.education.model.User;
import com.eric.education.model.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserDao {
    int countByExample(UserQuery example);

    int deleteByExample(UserQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserQuery example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

    int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}