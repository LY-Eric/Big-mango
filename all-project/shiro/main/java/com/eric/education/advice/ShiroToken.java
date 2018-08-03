package com.eric.education.advice;

import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * @author liuyang
 * @create 2018-05-31 15:08
 * @desc
 */
public class ShiroToken implements RememberMeAuthenticationToken {

    private String userName;

    private String password;

    /**
     * 是否记住我
     * 默认值：<code>false</code>
     */
    private boolean rememberMe = false;

    public ShiroToken(final String userName, final String password,
                      final boolean rememberMe) {
        this.userName = userName;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getRememberMe(){
        return rememberMe;
    }
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public Object getPrincipal() {
        return getUserName();
    }

    @Override
    public Object getCredentials() {
        return getPassword();
    }

    @Override
    public boolean isRememberMe() {
        return getRememberMe();
    }
}
