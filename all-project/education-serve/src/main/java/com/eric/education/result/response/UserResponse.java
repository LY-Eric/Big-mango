package com.eric.education.result.response;

import com.eric.education.result.EducationResult;

/**
 * @author Eric
 * @create 2018-06-16 下午12:27
 * @desc
 */
public class UserResponse extends EducationResult {

    /**
     * 返回给前段的用户标识符，后续从redis中获取用户的敏感信息
     */
    private String token;

    /**
     * 用户身份
     */
    private String identity;

    //--------------------------------------------------

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
