package com.eric.education.dao;

import com.eric.education.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDaoExtend {

    List<Role> queryUserRole(@Param("userId") String userId);

    void addRole(@Param("userId") String userId, @Param("roleId") String roleId);
}