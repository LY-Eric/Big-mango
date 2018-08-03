package com.eric.education.response;

import com.eric.education.common.AbstractResponse;
import com.eric.education.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuyang
 * @create 2018-05-30 17:01
 * @desc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends AbstractResponse {

    private User user;

    private List<User> userList;

    private Map<Long, String> map;

    //---------------------------------------------------

    public Map<Long, String> getMap() {
        return map;
    }

    public void setMap(Map<Long, String> map) {
        this.map = map;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
